package com.cskaoyan.controller.schedule;

import com.cskaoyan.bean.schedule.*;
import com.cskaoyan.service.schedule.ScheduleService;
import com.cskaoyan.utils.RandomId;
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

@Controller
public class ScheduleEditorController {
    @Autowired
    ScheduleService service;
    @RequestMapping("/order/update_all")
    @ResponseBody
    public MessageBean editorAll(Order order){
        if(service.updateOrder(order)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","修改失败",null );
    }
    @RequestMapping("/custom/update_all")
    @ResponseBody
    public MessageBean editor(Custom custom){
        System.out.println(custom);
        if(service.updateInfo(custom)==1){
         return new MessageBean("200","ok",null);
        }
    return new MessageBean("404","修改失败",null );
    }
    @RequestMapping("/product/update_all")
    @ResponseBody
    public MessageBean editor(Product product){
        if(service.updateInfo(product)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","修改失败",null );
    }
    @RequestMapping("/work/update_all")
    @ResponseBody
    public MessageBean editor(Work product){
        if(service.updateInfo(product)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","修改失败",null );
    }
//    @RequestMapping("/task/update_all")
//    @ResponseBody
//    public MessageBean editor(Task product){
//        if(service.updateInfo(product)==1){
//            return new MessageBean("200","ok",null);
//        }
//        return new MessageBean("404",null,null );
//    }
    @RequestMapping("/manufacture/update_all")
    @ResponseBody
    public MessageBean editor(Manufacture product){
        if(service.updateInfo(product)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","修改失败",null );
    }
    @RequestMapping("/order/update_note")
    @ResponseBody
    public MessageBean editor(Order order){
        if(service.updateInfo(order)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","修改失败",null );
    }
    @RequestMapping("/custom/update_note")
    @ResponseBody
    public MessageBean editorNote(Custom custom){
        if(service.updateInfo(custom)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","修改失败",null );
    }
    @RequestMapping("/product/update_note")
    @ResponseBody
    public MessageBean editorNote(Product product){
        if(service.updateInfo(product)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","修改失败",null );
    }

    @RequestMapping("/order/insert")
    @ResponseBody
    public MessageBean insertOrder(Order order){
        if(service.insertOrder(order)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","修改失败",null );
    }
    @RequestMapping("/custom/insert")
    @ResponseBody
    public MessageBean insertCustom(Custom custom){
        if(service.insertCustom(custom)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","添加失败",null );
    }
    @RequestMapping("/product/insert")
    @ResponseBody
    public MessageBean insertProduct(Product custom){
        if(service.insertProduct(custom)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","添加失败",null );
    }
    @RequestMapping("/work/insert")
    @ResponseBody
    public MessageBean insertWork(Work custom){
        if(service.insertWork(custom)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","添加失败",null );
    }
    @RequestMapping("/manufacture/insert")
    @ResponseBody
    public MessageBean insertManufacture(Manufacture custom){
        if(service.insertManufacture(custom)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","添加失败",null );
    }
//    @RequestMapping("/task/insert")
//    @ResponseBody
//    public MessageBean insertTask(Task custom){
//        if(service.insertTask(custom)==1){
//            return new MessageBean("200","ok",null);
//        }
//        return new MessageBean("404",null,null );
//    }
@RequestMapping("/order/delete_batch")
@ResponseBody
public MessageBean DeleteOrderConfirm(String[] ids){
    if(service.deleteOrderByID(ids)==ids.length){
        return new MessageBean("200","ok",null);
    }
    return new MessageBean("500","删除失败",null );
}
    @RequestMapping("/custom/delete_batch")
    @ResponseBody
    public MessageBean DeleteCustomConfirm(String[] ids){
        if(service.deleteCustomByID(ids)==ids.length){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("500","删除失败",null );
    }
    @RequestMapping("/product/delete_batch")
    @ResponseBody
    public MessageBean DeleteProductConfirm(String[] ids){
        if(service.deleteProductByID(ids)==ids.length){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("500","删除失败",null );
    }
    @RequestMapping("/work/delete_batch")
    @ResponseBody
    public MessageBean DeleteWorkConfirm(String[] ids){
        if(service.deleteWorkByID(ids)==ids.length){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("500","删除失败",null );
    }
    @RequestMapping("/manufacture/delete_batch")
    @ResponseBody
    public MessageBean DeleteManufactureConfirm(String[] ids){
        if(service.deleteManufactureByID(ids)==ids.length){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("500","删除失败",null );
    }
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
