package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = "pretty",
        features = {"classpath:features/demo1/is_it_friday_yet.feature"},//指定feature文件的classpath
        glue = "step_definition/demo1",//指定java脚本的包路径
        plugin = "html:target/cucumber"//生成html测试报告
)
public class IsItFridayTest {
}
