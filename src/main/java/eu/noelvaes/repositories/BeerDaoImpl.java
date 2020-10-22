package eu.noelvaes.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("beerDao")
public class BeerDaoImpl implements BeerDao{
    private final static String QUERY_ID =
            "SELECT Name,Alcohol,Price,Stock FROM Beers WHERE Id=?";
    private final static String UPDATE_STOCK =
            "UPDATE Beers SET STOCK=? WHERE Id=?";
    private final static String QUERY_ALC =
            "SELECT Name,Alcohol,Price,Stock FROM Beers WHERE Alcohol=?";
    private JdbcTemplate template;
//
//    @Autowired
//    public void setJdbcTemplate(JdbcTemplate template) {
//        this.template = template;
//    }

    @Override
    public String getBeersById(int id) {
        Map<String, Object> result = template.queryForMap(QUERY_ID, id);
        return String.format("%s %s %s %s",
                result.get("name"),
                result.get("alcohol"),
                result.get("price"),
                result.get("stock"));
    }

    @Override
    public void setStock(int id, int stock) {
        template.update(UPDATE_STOCK,stock,id);

    }

    @Override
    public List<String> getBeersByAlcohol(float alcohol) {
        List<Map<String, Object>> resultList =
                template.queryForList(QUERY_ALC, alcohol);
        List<String> rsList = new ArrayList<>();
        for (int i = 0 ; i < resultList.size() ; i++) {
            rsList.add(String.format("%s %s %s %S",
                    resultList.get(i).get("name"),
                    resultList.get(i).get("alcohol"),
                    resultList.get(i).get("price"),
                    resultList.get(i).get("stock")));
        }
        return rsList;
    }

}
