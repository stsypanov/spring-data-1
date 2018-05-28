package com.luxoft.logeek.service;

import com.luxoft.logeek.entity.Child;

/**
 * Created by Сергей on 02.04.2017.
 */
public interface ChildService {
    Child newChildForParent(long parentId);
}
