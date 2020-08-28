package com.inventory.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductMapper implements RowMapper<Product>{

	@Override
	public Product map(ResultSet rs, StatementContext ctx) throws SQLException {
		// TODO Auto-generated method stub
		return new Product(rs.getInt("id"), rs.getDouble("price")
				, rs.getFloat("discount"), rs.getString("category"), rs.getString("company")
				, rs.getString("color"), rs.getString("description"), rs.getInt("quantity"));
	}

}
