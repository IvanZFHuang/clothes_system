package org.javaboy.vhr.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.javaboy.vhr.mapper.EmpSalaryMapper;
import org.javaboy.vhr.mapper.SalaryMapper;
import org.javaboy.vhr.model.EmpSalary;
import org.javaboy.vhr.model.Salary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SalaryService {
    @Resource
    SalaryMapper salaryMapper;
    @Resource
    private EmpSalaryMapper empSalaryMapper;

    public List<Salary> getAllSalaries() {
        return salaryMapper.getAllSalaries();
    }

    public Integer addSalary(Salary salary) {
        salary.setCreateDate(new Date());
        return salaryMapper.insertSelective(salary);
    }

    public Integer deleteSalaryById(Integer id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }

    public Integer updateSalaryById(Salary salary) {
        return salaryMapper.updateByPrimaryKeySelective(salary);
    }


    /**
     * @return
     * @Date 2020/3/25 21:53
     * @Author jiangheng
     * @Description //TODO  查询员工的工资
     **/
    public PageInfo<Salary> listSalary(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<Salary> salaries = salaryMapper.listSalary(keyword);
        PageInfo<Salary> salaryPageInfo = new PageInfo<>(salaries);
        return salaryPageInfo;
    }

    public int getId() {
        return salaryMapper.getId();
    }

    public int insertEmpSalary(EmpSalary empSalary) {
        return empSalaryMapper.insertSelective(empSalary);
    }

    public Salary selectSalary(Integer id) {
        return salaryMapper.selectSalaryById(id);
    }
}
