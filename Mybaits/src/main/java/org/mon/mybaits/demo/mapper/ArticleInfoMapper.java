package org.mon.mybaits.demo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mon.mybaits.demo.model.ArticleInfo;

@Mapper
public interface ArticleInfoMapper {

    @Select("select * from article_info ta left join user_info tb on ta.uid=tb.id where ta.id=#{id}")
    ArticleInfo selectArticleInfoAndUserInfo (Integer id);
}
