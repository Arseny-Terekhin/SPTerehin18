package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProtectionCode {

    private String pathFile;
    private String nameFileOne;
    private String nameFileTwo;
    private String pathProtectionFile;
    ArrayList<String> variable = new ArrayList<>();//старые переменные
    ArrayList<String> variableNew = new ArrayList<>();//новые переменные
    ArrayList<String> className = new ArrayList<>();

    ProtectionCode(String pathOne, String pathTwo, String name1, String name2){
        this.pathFile = pathOne;
        this.nameFileOne =name1;
        this.nameFileTwo = name2;
        this.pathProtectionFile = pathTwo;
    }

    ProtectionCode(String pathOne, String pathTwo, String name1, String name2, ArrayList<String> ac){
        this.pathFile = pathOne;
        this.nameFileOne =name1;
        this.nameFileTwo = name2;
        this.pathProtectionFile = pathTwo;
        this.className = ac;
    }
    //удаление коментариев и лишних пробелов
    //код превращается в одну строку
    public void CleanComment() throws IOException {
        File fileOne = new File(pathFile, nameFileOne);
        BufferedReader readFile = new BufferedReader(new FileReader(fileOne));
        File fileTwo = new File(pathProtectionFile, nameFileTwo);
        BufferedWriter writFile = new BufferedWriter(new FileWriter(fileTwo));
        String s;
        String str;
        boolean coment = false;
        while (((s = readFile.readLine()) != null)){
            s = s.trim();
            if(s.contains("//")){
                str = s.substring(0, s.indexOf("//")) ;
                str = str.trim();
                if(str.equals("")){
                }else{
                    writFile.write(str);
                }
                continue;
            }
            if (s.equals("")){
                continue;
            }
            if (s.contains("/*")){
                str = s.substring(0, s.indexOf("/*")) ;
                str = str.trim();
                coment = true;
                if(str.equals("")){
                }else{
                    writFile.write(str);
                }
                continue;
            }

            if (coment){
                if(s.contains("*/")){
                    str = s.substring(s.indexOf("*/") + 2, s.length());
                    str = str.trim();
                    coment = false;
                    if(str.equals("")){
                    }else{
                        writFile.write(str);
                    }
                    continue;
                }else{
                    continue;
                }
            }
            writFile.write(s);
            writFile.flush();
        }
    }

    public ArrayList<String> renameClass() throws IOException {
        String clas = nameFileOne.substring(0,nameFileOne.indexOf(".txt"));//получение имени класса из пути
        //добавление имя старого класса и имя нового класса
        System.out.println(clas);
        className.add(clas);
        className.add(clas.substring(0, 2));
        return className;
    }


    //замена переменных
    public void renameVariable() {
        try {
            String lineAll = Files.readString(Path.of(pathProtectionFile + nameFileTwo));//считываем из файла где все в 1 строку
            String lineVars = lineAll.substring(lineAll.indexOf("class"));//срезаем часть с импортами, чтобы ничего в них не поменять

            //поиск переменно1
            Pattern email_pattern = Pattern.compile("[A-Z]\\w*.. (\\w*)[ ;.]");
            Matcher matcher = email_pattern.matcher(lineVars);



            while (matcher.find()) {
                String str = matcher.group(1);//выбор имени переменной
                if (str.length() > 2 && (!(str.equals("new"))&&!(str.equals("extends")) &&!(str.equals("InterruptedException")))){
                    //добавление переменной и замены её в два массива
                    variable.add(str);
                    variableNew.add(str.charAt(0) + str.substring(str.length()-1));
                }
            }
            //замена всех переменных используя два массива
            for (int i = 0; i< variable.size(); i++){
                String var = variable.get(i);
                String varNew = variableNew.get(i);
                lineVars = lineVars.replace(var, varNew);
            }

            for(int i = 0; i < className.size(); i += 2){
                lineVars = lineVars.replace(className.get(i),className.get(i + 1));
            }

            System.out.println(lineVars);
            //замена строки в которой уьраны все коментарии и пробелы на строку в котой еще заменены все переменные
            BufferedWriter bw = new BufferedWriter(new FileWriter(pathProtectionFile + nameFileTwo));
            bw.write(lineAll.substring(0, lineAll.indexOf("class")));
            bw.write(lineVars);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
