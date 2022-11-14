package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoreConfigEditorService {

    private final String INPUT = "src/main/resources/xml/input/CoreConfig.xml";
    private final String OUTPUT = "src/main/resources/xml/output/CoreConfig.xml";
    public void testEdit() throws IOException {
        File obj = null;
        FileChannel inputChannel = null, outputChannel = null;
        try {
            inputChannel = new FileInputStream(INPUT).getChannel();
            obj = new File(OUTPUT);
            obj.createNewFile();
            outputChannel = new FileOutputStream(OUTPUT).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            inputChannel.close();
            outputChannel.close();
        }
    }

    public void testReplaceLine() throws IOException {
        String lineToReplace = "<input name=\"Test Second Attempt Input\" port=\"1234\"/>";
        String replacementXML = "<note>Replacement Text</note>";
//        FileInputStream fstream = new FileInputStream(OUTPUT);
//        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
//        String line = "";
//        List<String> CoreConfigContentsList = new ArrayList<>();
//        while((line = br.readLine()) != null){
//            CoreConfigContentsList.add(line);
//            if(line.equals(lineToReplace)) continue;
//        }
        List<String> fileContent = new ArrayList<>(Files.readAllLines(Path.of(OUTPUT), StandardCharsets.UTF_8));

        for (int i = 0; i < fileContent.size(); i++) {
            System.out.println("**************************");
            System.out.println(fileContent.get(i).trim());
            System.out.println(lineToReplace);
            System.out.println("***************************");
            if (fileContent.get(i).trim().equals(lineToReplace)) {
                System.out.println("Got Here");
                fileContent.set(i, fileContent.get(i).replace(lineToReplace, replacementXML));
                break;
            }
        }
        Files.write(Path.of(OUTPUT), fileContent, StandardCharsets.UTF_8);
    }
}
