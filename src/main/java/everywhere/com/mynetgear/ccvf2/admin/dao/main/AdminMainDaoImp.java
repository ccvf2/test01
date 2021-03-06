/**
 * @author 배성욱
 * @createDate 2015. 12. 6.
 * @described 클래스가 하는 일을 적어주세요.
 * @reference Controller, service, DTO, DAO, 등..
 */
package everywhere.com.mynetgear.ccvf2.admin.dao.main;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author 배성욱
 * @createDate 2015. 12. 6.
 * @described 관리자메인 데이터베이스 작업 
 * @reference class
 * 소스트리 싫다......ㅜㅠ 이거 안하면 안되요? 하기 시러요
 * ㅇㄹㄴㄴㅇ리ㅏ허ㅣ
 */
@Component
public class AdminMainDaoImp implements AdminMainDao {
	@Autowired
	private SqlSessionTemplate sqlTemplate;
	
	/* 트랜젝션 처리시 */
	@Autowired
	private PlatformTransactionManager transactionManager;

	@Override
	public int test() {
		// 트랜잭션처리시 필요한 객체
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus status=transactionManager.getTransaction(definition);
		int result=0;
		try{
			result= sqlTemplate.selectOne("select_count");
			//커밋
			transactionManager.commit(status);
		}catch(Throwable e){
			//롤백
			transactionManager.rollback(status);
			e.printStackTrace();
		}
		return result;
	}

}
