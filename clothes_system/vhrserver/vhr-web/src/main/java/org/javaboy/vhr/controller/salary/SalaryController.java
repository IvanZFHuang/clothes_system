package org.javaboy.vhr.controller.salary;

import com.github.pagehelper.PageInfo;
import org.javaboy.vhr.model.EmpSalary;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.Salary;
import org.javaboy.vhr.service.EmployeeService;
import org.javaboy.vhr.service.SalaryService;
import org.javaboy.vhr.utils.AjaxRusult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/salary/sob")
public class SalaryController {
    @Autowired
    SalaryService salaryService;
    @Resource
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    /**
     * @return 添加工资条信息
     * @Date 2020/3/27 14:54
     * @Author jiangheng
     * @Description //TODO
     **/
    @PostMapping("/addSalaryInfo")
    @Transactional
    public RespBean addSalary(@RequestBody Salary salary) {
        System.out.println(salary);
        if (salaryService.addSalary(salary) == 1) {
            int userid = employeeService.getId(salary.getWorkID());
            int salaryId = salaryService.getId();
            EmpSalary empSalary = new EmpSalary();
            empSalary.setEid(userid);
            empSalary.setSid(salaryId);
            //修改状态
            employeeService.updateIsEntry(userid);
            //插入关联表中
            salaryService.insertEmpSalary(empSalary);

            return RespBean.ok("添加成功!");

        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("delete/{id}")
    public RespBean deleteSalaryById(@PathVariable Integer id) {
        if (employeeService.delete(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @RequestMapping("/selectSalaryById")
    public AjaxRusult selectSalaryById(Integer id) {
        Salary salary = salaryService.selectSalary(id);
        return AjaxRusult.ok().put("obj", salary);
    }

    @PutMapping("/update")
    public RespBean updateSalary(@RequestBody Salary salary) {
        if (salaryService.updateSalaryById(salary) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    /**
     * @return
     * @Date 2020/3/25 22:23
     * @Author jiangheng
     * @Description //TODO 查询员工的工资
     **/
    @RequestMapping("/listSalary")
    public Map<String, Object> listSalary(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize, String keyword) {
        Map<String, Object> map = new HashMap<>();
        PageInfo<Salary> salaryPageInfo = salaryService.listSalary(pageNum, pageSize, keyword);
        if (salaryPageInfo.getList().size() > 0 && salaryPageInfo.getList() != null) {
            map.put("msg", "成功获取数据");
            map.put("obj", salaryPageInfo.getList());
            map.put("obj1", salaryPageInfo.getTotal());
            return map;
        } else {
            map.put("msg", "获取数据失败");
            return map;
        }
    }


}