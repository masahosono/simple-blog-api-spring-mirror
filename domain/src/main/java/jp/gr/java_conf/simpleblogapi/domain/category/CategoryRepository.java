package jp.gr.java_conf.simpleblogapi.domain.category;

public interface CategoryRepository {

    CategoryList getCategory();

    Category getCategoryById(int id);

    int registerCategory(String name, Integer parentId);

}
