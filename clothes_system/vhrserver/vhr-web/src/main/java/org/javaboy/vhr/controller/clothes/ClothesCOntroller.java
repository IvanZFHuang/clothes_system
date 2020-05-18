package org.javaboy.vhr.controller.clothes;

import com.github.pagehelper.PageInfo;
import org.javaboy.vhr.model.*;
import org.javaboy.vhr.service.ClothesService;
import org.javaboy.vhr.utils.AjaxRusult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/4/18 14:28
 * @Version 1.0
 */
@RestController
@RequestMapping("/basic/clothes")
public class ClothesCOntroller {
    @Resource
    private ClothesService clothesService;

    /**
     * @return
     * @Date 2020/4/18 15:13
     * @Author jiangheng
     * @Description //TODO 获取所有的洗衣信息
     **/
    @GetMapping("/listClothes")
    public Map<String, Object> listClothes(String keyword, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Map<String, Object> map = new HashMap<>(16);
        PageInfo<ClothesDetail> clothesDetailPageInfo = clothesService.listClothes(keyword, pageNum, pageSize);
        if (clothesDetailPageInfo.getTotal() > 0) {
            map.put("obj", clothesDetailPageInfo.getList());
            map.put("obj1", clothesDetailPageInfo.getTotal());
            map.put("msg", "查询成功");
        } else {
            map.put("msg", "没有数据");
        }
        return map;
    }

    /**
     * @return
     * @Date 2020/4/19 13:14
     * @Author jiangheng
     * @Description //TODO  查询所有的类型
     **/
    @GetMapping("/listClothesType")
    public AjaxRusult listClothesType() {
        return AjaxRusult.ok().put("obj", clothesService.listClothesTypePrice());
    }

    @GetMapping("/selectPrice")
    public AjaxRusult selectPrice(Integer typeId) {
        if (typeId != null) {
            return AjaxRusult.ok().put("obj", clothesService.selectByPrimaryKey(typeId));
        } else {
            return AjaxRusult.ok().put("obj", 0);
        }

    }

    @PostMapping("/insertClothes")
    public AjaxRusult insertClothes(@RequestBody Clothes clothes) {
        int count = clothesService.insertClothes(clothes);
        if (count > 0) {
            return AjaxRusult.ok().put("msg", "添加成功");
        } else {
            return AjaxRusult.error(500, "添加失败");
        }
    }

    /**
     * @return
     * @Date 2020/4/20 21:55
     * @Author jiangheng
     * @Description //TODO 非会员添加收衣
     **/
    @PostMapping("/insertNomemClothes")
    public AjaxRusult insertNomemClothes(@RequestBody NomemClothes nomemClothes) {
        return clothesService.insertNomemClothes(nomemClothes);
    }

    @RequestMapping("/updateClothes")
    public AjaxRusult updateClothes(@RequestBody Map<String, Object> map) {
        return clothesService.updateClothes(map);
    }

    /**
     * @return
     * @Date 2020/4/23 11:13
     * @Author jiangheng
     * @Description //TODO 取衣
     **/
    @PutMapping("/takeClothes/{clothesId}")
    public AjaxRusult takeClothes(@PathVariable("clothesId") Integer clothesId) {
        return clothesService.takeClothes(clothesId);
    }

    /**
     * @return
     * @Date 2020/4/23 13:42
     * @Author jiangheng
     * @Description //TODO 已洗完
     **/
    @PutMapping("/completed/{clothesId}")
    public AjaxRusult completed(@PathVariable("clothesId") Integer clothesId) {
        return clothesService.completed(clothesId);
    }

    @PostMapping("/rewash")
    public AjaxRusult rewash(@RequestBody Rewash rewash) {
        return clothesService.rewash(rewash);
    }

    @PostMapping("/refound")
    public AjaxRusult refound(@RequestBody Refound refound) {
        return clothesService.refound(refound);
    }

    /**
     * @return
     * @Date 2020/4/23 17:15
     * @Author jiangheng
     * @Description //TODO 获取正在洗的衣服和未领取的衣服
     **/
    @GetMapping("/listClothesPro")
    public AjaxRusult listClothesPro() {
        return AjaxRusult.ok().put("obj", clothesService.listClothesPro());
    }
}
