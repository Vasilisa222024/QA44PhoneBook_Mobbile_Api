package helper;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int retryCount=0;
    private  static  int maxTtyValue=3;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount<maxTtyValue){
            retryCount++;
            return true;
        }
        return false;
    }
}
