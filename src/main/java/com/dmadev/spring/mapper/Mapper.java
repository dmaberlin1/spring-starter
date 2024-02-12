package com.dmadev.spring.mapper;

public interface Mapper<F,T> {
   T map(F object);

   //дефолт метод- чтобы не все реализовывали, а кто захочет переопределит
   default T map(F fromObject,T toObject){
      return toObject;
   }
}
