package qb;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConnectNetWork {

	/**
	 * 执行CMD命令,并返回String字符串
	 * 
	 * @param strCmd
	 * @return
	 * @throws Exception
	 */
	public String exeCmd(String strCmd) throws Exception {
		Process p = Runtime.getRuntime().exec("cmd /c " + strCmd);
		StringBuilder sbCmd = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(p
				.getInputStream()));
		String line = null;
		while ((line = br.readLine()) != null) {
			sbCmd.append(line + "\n");
		}
		return sbCmd.toString();
	}

	/**
	 * 切断ADSL
	 * 
	 * @param adslTitle
	 * @return
	 * @throws Exception
	 */
	public boolean cutAdsl(String adslTitle) throws Exception {
		// 加上"" 防止空格
		String cutAdsl = "rasdial \"" + adslTitle + "\" /disconnect";
		String result = exeCmd(cutAdsl);
		if (result.indexOf("没有连接") != -1) {
			System.err.println(adslTitle + "连接不存在!");
			return false;
		} else {
			System.out.println("连接已断开");
			return true;
		}
	}

	/**
	 * 连接ADSL
	 * 
	 * @param adslTitle
	 * @param adslName
	 * @param adslPass
	 * @param adslPhone
	 * @return
	 * @throws Exception
	 */
	public boolean connAdsl(String adslTitle, String adslName,
			String adslPass, String adslPhone) throws Exception {
		// 加上"" 防止空格
		String adslCmd = "rasdial \"" + adslTitle + "\" " + adslName + " "
				+ adslPass + " /phone:" + adslPhone;
		String tempCmd = exeCmd(adslCmd);
		if (tempCmd.indexOf("已连接") > 0) {
			System.out.println("已成功建立连接.");
			return true;
		} else {
			System.err.println(tempCmd);
			System.err.println("建立连接失败");
			return false;
		}
	}

}