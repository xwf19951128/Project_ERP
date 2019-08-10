package com.cskaoyan.controller.technology;

import com.cskaoyan.bean.technology.Process;
import com.cskaoyan.bean.technology.QueryResult;
import com.cskaoyan.service.technology.ProcessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    ProcessService processService;

    @RequestMapping("/find")
    public String find(HttpServletRequest request){
        //需要设置sysPermissionList
        //还需要添加一个用于权限管理的集合
        ArrayList<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("process:add");
        sysPermissionList.add("process:edit");
        sysPermissionList.add("process:delete");
        request.getSession().setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/process_list.jsp";
    }

    @RequestMapping("/list")
    @ResponseBody
    public QueryResult<Process> listProcess(){
        PageHelper.startPage(1,10);
        List<Process> processes1 = processService.queryAllProcesses();
        long total = new PageInfo<>(processes1).getTotal();
        QueryResult<Process> processQueryResult = new QueryResult<>();
        processQueryResult.setRows(processes1);
        processQueryResult.setTotal((int) total);
        return processQueryResult;
    }

//    @RequestMapping("/get_data")
//    @ResponseBody
//    public List<Process> get_data(){
//        List<Process> processes = processService.queryAllProcesses();
//        return processes;
//    }

    //新增add需要校验
    @RequestMapping("/add_judge")
    @ResponseBody
    public Map add_judge(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        return objectObjectHashMap;
    }

    //add方法可以跳转到add页面
    @RequestMapping("/add")
    public String add(){
        return "/WEB-INF/jsp/process_add.jsp";
    }

    //输入要增加的工序信息后，会把信息发送到insert方法中
    //注意，表单传过来的并不是Json格式的数据，这一点算是个坑
    //但是返回值必须是jason！！！！！
    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(Process process) {
        HashMap<String, Object> result = new HashMap<>();
        String processId = process.getProcessId();
        List<Process> processes = processService.queryProcessByProcessId(processId);
        if (process != null) {
            result.put("status", 500);
            result.put("msg", "ID重复，请重新输入ID");
        } else {
            int i = processService.insertProcess(process);
            if (i == 1) {
                result.put("status", 200);
                result.put("msg", "ok");
            } else {
                result.put("status", 288);
                result.put("msg", "添加失败，请确定参数是否正确");
            }
        }
        return result;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public Map judge(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        return objectObjectHashMap;
    }

    //删除
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map delete(int[] ids){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        int i = processService.deleteProcess(ids);
        if (i==ids.length){
            stringObjectHashMap.put("status",200);
            stringObjectHashMap.put("msg","OK");
        }else {
            stringObjectHashMap.put("status",288);
            stringObjectHashMap.put("msg","删除失败，请重试");
        }
        return stringObjectHashMap;
    }

    //编辑需要权限验证
    @RequestMapping("/edit_judge")
    @ResponseBody
    public Map edit_judge(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        return objectObjectHashMap;
    }

    //权限验证通过后，window组件会调用edit方法,跳转到编辑页面
    @RequestMapping("/edit")
    public String edit(){
        return "/WEB-INF/jsp/process_edit.jsp";
    }

    //修改页面提交表单，会把数据提交到这个update_All方法
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update(Process process){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        int i = processService.updateProcess(process);
        if (i==1){
            stringObjectHashMap.put("status",200);
            stringObjectHashMap.put("msg","OK");
        }else {
            stringObjectHashMap.put("status",288);
            stringObjectHashMap.put("msg","更新失败，请重试");
        }
        return stringObjectHashMap;
    }

    //查询1：根据工序编号模糊查询工序
    @RequestMapping("/search_process_by_processId")
    @ResponseBody
    public List<Process> queryProcessByProcessId(String searchValue){
        String search = "%"+searchValue+"%";
        List<Process> processes = processService.queryProcessByProcessId(search);
        return processes;
    }

    //查询2：根据工艺计划编号模糊查询工序
    @RequestMapping("/search_process_by_technologyPlanId")
    @ResponseBody
    public List<Process> queryProcessByPlanId(String searchValue){
        String search = "%"+searchValue+"%";
        List<Process> processes = processService.queryProcessByPlanId(search);
        return processes;
    }
}
