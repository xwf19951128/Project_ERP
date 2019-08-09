package com.cskaoyan.controller.schedule;

import com.cskaoyan.bean.schedule.*;
import com.cskaoyan.service.ScheduleService;
import com.cskaoyan.utils.RandomId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class ScheduleEditorController {
    @Autowired
    ScheduleService service;
    @RequestMapping("custom/update_all")
    @ResponseBody
    public MessageBean editor(Custom custom){
        System.out.println(custom);
        if(service.updateInfo(custom)==1){
         return new MessageBean("200","ok",null);
        }
    return new MessageBean("404",null,null );
    }
    @RequestMapping("product/update_all")
    @ResponseBody
    public MessageBean editor(Product product){
        if(service.updateInfo(product)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404",null,null );
    }
    @RequestMapping("order/update_note")
    @ResponseBody
    public MessageBean editor(Order order){
        if(service.updateInfo(order)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404",null,null );
    }
    @RequestMapping("order/update_all")
    @ResponseBody
    public MessageBean editorAll(Order order){
        if(service.updateOrder(order)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404",null,null );
    }
    @RequestMapping("order/insert")
    @ResponseBody
    public MessageBean insertOrder(Order order){
        if(service.insertOrder(order)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404",null,null );
    }
    @RequestMapping("file/upload")
    @ResponseBody
    public FileUpLoadBean fileupload(MultipartFile file,HttpServletRequest request){
        if(file==null){
            return new FileUpLoadBean(1,"");
        }
        String realpath=request.getSession().getServletContext().getRealPath("WEB-INF/file/"+file.getOriginalFilename());
        File newfile=new File(realpath);
        try {
            file.transferTo(newfile);
        } catch (IOException e) {
            e.printStackTrace();
            return new FileUpLoadBean(1,"");
        }
        return new FileUpLoadBean(0,"/file/"+file.getOriginalFilename());
    }
    @RequestMapping("pic/upload")
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
    @RequestMapping("/order/delete_batch")
    @ResponseBody
    public MessageBean DeleteOrderconfirm(String ids){
        if(service.deleteOrderByID(ids)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("500",null,null );
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
        if(deletedFile.exists()){
            success.put("data","success");
            return success;
        }
        success.put("data","failed");
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
    @ResponseBody
    public HashMap<String, String> fileDownLoad(String fileName,HttpServletRequest request){
        String realpath=request.getSession().getServletContext().getRealPath("WEB-INF"+fileName);
        File deletedFile=new File(realpath);
        HashMap<String, String> success = new HashMap<>();
        success.put("data","success");
        return success;
    }
}
