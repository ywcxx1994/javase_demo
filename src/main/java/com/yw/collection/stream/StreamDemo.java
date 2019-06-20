package com.yw.collection.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        List<Article> namelist = new ArrayList<Article>();
        getFirstFromArticleList(namelist);

    }

    /**
     * 查找包含“Java”标签的第一篇文章
     *
     * @param namelist
     * @return
     */
    private static Optional<Article> getFirstFromArticleList(List<Article> namelist) {
        return namelist.stream()
                .filter(article -> article.getTags().contains("Java"))
                .findFirst();
    }

    /**
     * 查找包含“Java”标签的所有文章
     *
     * @param namelist
     * @return
     */
    private static List<Article> getContainsFromArticleList(List<Article> namelist) {
        return namelist.stream()
                .filter(article -> article.getTags().contains("Java"))
                .collect(Collectors.toList());
    }

}
