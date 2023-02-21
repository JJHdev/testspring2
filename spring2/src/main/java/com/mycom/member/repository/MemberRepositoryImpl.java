package com.mycom.member.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mycom.member.domain.Member;


@Repository
public class MemberRepositoryImpl implements MemberRepository{
	
	/* bean으로 등록해둔 dataSource를 이용하여 jdbcTemplate클래스 객체를 자동주입시켜야 한다.
	    여기에서는 servlet-context.xml에서 아래와 같이 설정
    <beans:bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
       <beans:property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>  
       <beans:property name="url" value="jdbc:mysql://localhost:3306/spdb?serverTimezone=UTC&amp;characterEncoding=utf8"/> 
       <beans:property name="username" value="spuser"/> 
       <beans:property name="password" value="sppw"/>  
   </beans:bean>

   <beans:bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">  
       <beans:property name="dataSource" ref="dataSource"/>
   </beans:bean>  
	    
	 *  */
	private JdbcTemplate template;
	
	
	@Autowired 
	public void setDataSource(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource); 
	}
	
	//회원등록처리
    /*update(String sql,Object... args):JdbcTemplate에서 insert쿼리문 실행
	  파라미터
	  String sql: 실행쿼리문(insert문,update문,delete문)
	  Object... args:?에 해당하는 내용
	 리턴타입  int : 실행된 쿼리문의 row수 
     */
	@Override
	public void setNewMember(Member member) {
		String sql = "insert into simplemember(id,passwd,gender,name,regdate) "+ 
					 "value (?,?,?,?,?)";
		this.template.update(sql,
							member.getId(),
							member.getPasswd(),
							member.getGender(),
							member.getName(),
							member.getRegdate()
				);
	}
	
	/*queryForObject(String sql)
	 *queryForObject(String sql,RowMapper<T> rowMapper)
	 *queryForObject(String sql,Object[] args,RowMapper<T> rowMapper)
	 *파라미터 
	  String sql:실행쿼리문
	  RowMapper<T> rowMapper: 실행결과객체
	  Object[] args:?에 해당하는 부분
	 */
	

	//파라미터 : 조회하고자 하는 회원id
	//리턴타입 Member : 상세회원정보
	@Override
	public Member getMemberById(String id) {
		
		String sql = "select id,passwd,gender,name,regdate " + 
					 "from simplemember " + 
					 "where id=?";
		
		Member member = template.queryForObject(sql,new MemberRowMapper(),id);
		return member;
		
	}

	@Override
	public List<Member> getAllMemberList() {
		String sql ="select id,passwd,gender,name,regdate " + 
					"from simplemember";
		List<Member> memberList = this.template.query(sql,new MemberRowMapper());
		return memberList;
	}

	
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
	
	@Override
	public void modiMember(Member member) {
			String sql = "update simplemember "+ 
						 "set gender=?, passwd=? "+
						 "where id=? ";
			int cnt = this.template.update(sql,
								member.getGender(),
								member.getPasswd(),
								member.getId());
			System.out.println("cnt"+cnt);
		}

	@Override
	public void deleteMember(Member member) {
		String sql = "delete from simplemember "+ 
				 	"where id=? ";
	int cnt = this.template.update(sql,
						member.getId());
	System.out.println("cnt"+cnt);
		
	}
}
	
	
	
