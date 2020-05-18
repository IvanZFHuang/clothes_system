package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Clothes;
import org.javaboy.vhr.model.ClothesDetail;

import java.util.List;

/**
 * @author Administrator
 */
public interface ClothesMapper {
    int deleteByPrimaryKey(Integer clothesId);

    int insert(Clothes record);

    int insertSelective(Clothes record);

    Clothes selectByPrimaryKey(Integer clothesId);

    int updateByPrimaryKeySelective(Clothes record);

    int updateByPrimaryKey(Clothes record);

    /**
     * @return werw
     * @Date 2020/4/15 18:22
     * @Author jiangheng
     * @Description //TODO 获取洗衣详情
     **/
    List<ClothesDetail> listClothes(@Param("keyword") String keyword, @Param("id") Integer id);

    /**
     * @return
     * @Date 2020/4/19 23:19
     * @Author jiangheng
     * @Description //TODO 修改挂衣号
     **/
    void updateNum(@Param("id") Integer id, @Param("clothesNum") String clothesNum);

    //修改付费状态
    void updateIsPay(@Param("clothesId") Integer clothesId);

    /**
     * @return
     * @Date 2020/4/23 11:28
     * @Author jiangheng
     * @Description //TODO 取衣
     **/
    void updateTakeClothes(@Param("clothesId") Integer clothesId, @Param("date") String date, @Param("status") String status);

    void updateStates(@Param("status") String status, @Param("clothesId") Integer clothesId);

    /**
     * @return
     * @Date 2020/4/23 14:35
     * @Author jiangheng
     * @Description //TODO 修改收衣和 预计完成时间
     **/
    void updateTime(@Param("clothesId") Integer clothesId, @Param("preTime") String preTime, @Param("formatDate") String formatDate);

    /**
     * @return
     * @Date 2020/4/23 17:15
     * @Author jiangheng
     * @Description //TODO 获取正在洗的衣服和未领取的衣服
     **/
    List<ClothesDetail> listClothesPro();
}