package com.springboot.shoppy_fullstack_app.repository;

import com.springboot.shoppy_fullstack_app.dto.ProductDto;
import com.springboot.shoppy_fullstack_app.dto.ProductDetailinfoDto;
import com.springboot.shoppy_fullstack_app.dto.ProductQna;
import com.springboot.shoppy_fullstack_app.dto.ProductReturn;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcTemplateProductRepository  implements ProductRepository{
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplateProductRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public ProductReturn findReturn() {
        String sql = "select rid, title, description, list from product_return";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ProductReturn.class));
    }

    @Override
    public List<ProductQna> findQna(int pid) {
        String sql = """
                    select  qid, 
                            title, 
                            content, 
                            is_complete as isComplete, 
                            is_lock as isLock, 
                            id, 
                            pid, 
                            cdate
                    from product_qna 
                    where pid = ? 
                 """;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductQna.class), pid);
    }

    @Override
    public ProductDetailinfoDto findProductDetailinfo(int pid) {
        String sql = " select did, title_en as titleEn, title_ko as titleKo, pid, list"
                   + " from product_detailinfo"
                   + " where pid = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ProductDetailinfoDto.class), pid);
    }

    @Override
    public ProductDto findByPid(int pid) {
        String sql = "select pid, name, price, info, rate, trim(image) as image, imgList from product where pid = ?";
        ProductDto product = jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(ProductDto.class),  pid);
        return product;
    }

    @Override
    public List<ProductDto> findAll() {
        String sql = "select pid, name, price, info, rate, trim(image) as image, imgList from product";
        List<ProductDto> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductDto.class));

        return list;
    }
}
