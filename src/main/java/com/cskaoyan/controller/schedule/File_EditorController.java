package com.cskaoyan.controller.schedule;

import com.cskaoyan.bean.schedule.*;
import com.cskaoyan.service.schedule.ScheduleService;
import com.cskaoyan.util.RandomId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * 这是执行所有与文件相关操作的Controller
 */
@Controller
public class File_EditorController {
    @Autowired
    ScheduleService service;
    @RequestMapping("/file/upload")
    @ResponseBody
    public FileUpLoadBean fileupload(MultipartFile file,HttpServletRequest request){
        if(file==null){
            return new FileUpLoadBean(1,"");
        }
        String randomid=RandomId.getShortRandomId();
        String realpath=request.getSession().getServletContext().getRealPath("WEB-INF/file/"+randomid+file.getOriginalFilename());
        File newfile=new File(realpath);
        try {
            file.transferTo(newfile);
        } catch (IOException e) {
            e.printStackTrace();
            return new FileUpLoadBean(1,"");
        }
        return new FileUpLoadBean(0,"/file/"+randomid+file.getOriginalFilename());
    }
    @RequestMapping("/pic/upload")
    @ResponseBody
    public FileUpLoadBean picupload(MultipartFile uploadFile ,HttpServletRequest request){
        if(uploadFile==null){
            return new FileUpLoadBean(1,"");
        }
        String randomid=RandomId.getRandomId();
        String realpath=request.getSession().getServletContext().getRealPath("WEB-INF/image/"+randomid+uploadFile.getOriginalFilename());
        File newfile=new File(realpath);
        try {
            uploadFile.transferTo(newfile);
            return new FileUpLoadBean(0,"/image/"+randomid+uploadFile.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
            return new FileUpLoadBean(1,"");
        }
    }
    @RequestMapping("/file/delete")
    @ResponseBody
    public HashMap<String, String> deleteFile(String fileName,HttpServletRequest request){
        if(fileName.contains("fileName=/file")){
    String[] filetemp=fileName.split("fileName=/file");
            fileName=filetemp[1];
    }
        String realpath=request.getSession().getServletContext().getRealPath("WEB-INF/file/"+fileName);
        File deletedFile=new File(realpath);
        HashMap<String, String> success = new HashMap<>();
            success.put("data","success");
        return success;
    }
    @RequestMapping("/pic/delete")
    @ResponseBody
    public HashMap<String, String> deletePic(String picName,HttpServletRequest request){
        String realpath=request.getSession().getServletContext().getRealPath("WEB-INF"+picName);
        File deletedFile=new File(realpath);
        HashMap<String, String> success = new HashMap<>();
            success.put("data","success");
            return success;
    }
    @RequestMapping("/file/download")
    public String fileDownLoad(String fileName, HttpServletResponse response){
        response.setHeader("Content-Disposition","attachment;"+fileName);
        return fileName;
    }
}
