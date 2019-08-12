package com.cskaoyan.controller.schedule;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 这是一个判断是否跳转的Controller
 */
@Controller
public class JudgeController {
    /*
     * 以下部分时编辑时的操作
     */
    @RequestMapping("/custom/edit_judge")
    @ResponseBody
    public String goEditC(){
        return null;
    }
    @RequestMapping("/product/edit_judge")
    @ResponseBody
    public String goEditP(){
        return null;
    }
    @RequestMapping("/order/edit_judge")
    @ResponseBody
    public String goEditOrderNote(){
        return null;
    }
    @RequestMapping("/work/edit_judge")
    @ResponseBody
    public String goEditWork0(){
        return null;
    }
    @RequestMapping("/manufacture/edit_judge")
    @ResponseBody
    public String goEditmanufacture0(){
        return null;
    }
    @RequestMapping("/task/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return null;
    }

    /*
     * 以下部分是增加时的操作
     */
    @RequestMapping("/task/add_judge")
    @ResponseBody
    public String add_judge(){
        return null;
    }
    @RequestMapping("/order/add_judge")
    @ResponseBody
    public String goAddOrder(){
        return null;
    }
    @RequestMapping("/custom/add_judge")
    @ResponseBody
    public String goAddCustom0(){
        return null;
    }
    @RequestMapping("/product/add_judge")
    @ResponseBody
    public String goAddProduct0(){
        return null;
    }
    @RequestMapping("/work/add_judge")
    @ResponseBody
    public String goAddWork0(){
        return null;
    }
    @RequestMapping("/manufacture/add_judge")
    @ResponseBody
    public String goAddManufacture0(){
        return null;
    }

    /**
     * 以下部分是删除时的操作
     * @return
     */
    @RequestMapping("/order/delete_judge")
    @ResponseBody
    public String goDeleteOrder(){
        return null;
    }
    @RequestMapping("/custom/delete_judge")
    @ResponseBody
    public String goDC(){
        return null;
    }
    @RequestMapping("/product/delete_judge")
    @ResponseBody
    public String goDP(){
        return null;
    }
    @RequestMapping("/work/delete_judge")
    @ResponseBody
    public String goDW(){
        return null;
    }
    @RequestMapping("/manufacture/delete_judge")
    @ResponseBody
    public String goDM(){return null;
    }
    @RequestMapping("/task/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return null;
    }
}
