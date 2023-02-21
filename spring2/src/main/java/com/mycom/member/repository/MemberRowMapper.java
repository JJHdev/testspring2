package com.mycom.member.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mycom.member.domain.Member;

/*queryForObject():select쿼리문 실행결과를 특정객체(도메인객체)로 매핑하여 리턴.
-select실행결과가 0 또는 2개이상이면 IncorrectResultSizeDataAccessException 발생
-select실행결과가 특정객체(도메인객체)로 매핑하려면 
 RowMapper인터페이스를 구현한 rowMapper클래스가 있어야 한다.
-RowMapper인터페이스에서 제공하는 mapRow()의 내부에는
 select실행결과로 받은 각 행(row)의 정보를  
   어떤 특정객체(도메인객체)로 매핑할 것인지를 작성하면 된다.

*문법
queryForObject(String sql)
queryForObject(String sql,RowMapper<T> rowMapper)
queryForObject(String sql,RowMapper<T> rowMapper,Object...args)
*파라미터 
String sql:실행쿼리문
RowMapper<T> rowMapper: 실행결과객체
Object...args:?에 해당하는 부분
*동작 : 스프링컨테이너는 sql문을 실행 -> 자동으로  RowMapper객체의 mapRow()를 호출
*/
public class MemberRowMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member member = new Member();
		
			member.setId(rs.getString("id"));
			member.setPasswd(rs.getString("passwd"));
			member.setName(rs.getString("name"));
			member.setGender(rs.getString("gender"));
			member.setRegdate(rs.getString("regdate"));
			
		return member;
	}
}
