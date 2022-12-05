package Test;

import com.zzz.mvc.Mappers.AccountMapper;
import com.zzz.mvc.Mappers.FriendsMapper;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.Date;

public class Tests {

    private ApplicationContext applicationContext;
    private final Logger logger = Logger.getLogger(Tests.class);

    @Before
    public void setUp() {
        applicationContext = new ClassPathXmlApplicationContext(
                "com/zzz/mvc/config/Spring/applicationContext.xml");
    }

    @Test
    public void selectOneUser() {
        logger.debug("start debug");
        AccountMapper accountMapper = applicationContext.getBean(AccountMapper.class);

        System.out.println(accountMapper.queryAccountInfoByEmail(
                "dmxyzlzt@gmail.com"));
    }

    @Test
    public void selectAllFriends() {
        FriendsMapper friendsMapper = applicationContext.getBean(FriendsMapper.class);
        System.out.println(friendsMapper.selectAllFriendsById(1));
    }

    @Test
    public void testTimeStamp(){
        Date a = new Date();

        System.out.println(a.toString());
    }
}
