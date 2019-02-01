package com.cuizhiwen.jdk.designpattern.mvc;

import java.util.List;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/1 9:38
 */
public interface PetDao {
    /**
     * 查询所有宠物
     * @return
     * @throws Exception
     */
    List<Pet> findAllPets() throws Exception;
}
