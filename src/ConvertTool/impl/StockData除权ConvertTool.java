package ConvertTool.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import InputData.InputDataUtil除权;
import OutputData.OutputDataUtil爸爸;
import OutputData.feihu.OutputDataUtil飞狐;
import OutputData.feihu.除权DataOutputBean飞狐;

public class StockData除权ConvertTool extends StockData爸爸 implements ConvertTool.ConvertTool {

	private String[] s最后交易日期;

	public StockData除权ConvertTool() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void 输出到文件(String inputFileFullPathName) {
		// TODO 自動生成されたメソッド・スタブ

	}

	/**
	 *
	 */
	public void 输出到除权文件() {

		this.s最后交易日期 = new String[1];
		// this.sDate = "20190507";
		//List<String[]> todayDatas = new ArrayList<String[]>();
		List<String> out除权数据list = new ArrayList<String>();
		// 取得最后交易日的成交数据

		byte[] outputTofile最终整合出力数据 = new byte[0];
		byte[] resultByte深沪股票除权输出数据 = new byte[0];

		byte[] outHeader = null;
		byte[] outType = null;
		byte[] 股票数 = null;

//		byte[] resultByte一个文件 = new byte[0];
		int[] outi股票数 = {0};


		if(InputDataUtil除权.取得除权数据和最后交易日(out除权数据list, s最后交易日期)) {
			// 1、事前判断
			// todayDatas.add("0	002191	4052	12.580000	13.410000	12.980000	13.800000	12.220000	14999043	-1258	591083	4542	762218816.000000	327635	263448	6	129813	12.580000	12.590000	1280	1113	12.570000	12.600000	22	112	12.530000	12.610000	93	30	12.520000	12.620000	850	178	12.510000	12.630000	4	280	3402	0	-57	187	-65	0.400000	4052");
			if(out除权数据list == null || out除权数据list.size() <= 0) {return;}

			// 2、解析取到的深沪股票除权输出数据:把除权信息做成出力格式
			List<String> in除权数据list = out除权数据list;
			除权DataOutputBean飞狐 out除权dataOutputBean飞狐 = new 除权DataOutputBean飞狐();
			resultByte深沪股票除权输出数据 = 解析取到的深沪股票除权输出数据(in除权数据list, outi股票数, out除权dataOutputBean飞狐);

			// 3、如果没有有效的除权股票，就退出
			if(outi股票数[0] == 0) return;
			//    否则、计算有效股票数的输出格式
			else if(股票数 == null) 股票数 = OutputDataUtil爸爸.convertInttoBytePublic(outi股票数[0]);

			// 4、做成最终整合出力数据
			outputTofile最终整合出力数据 = OutputDataUtil爸爸.数组合并(outHeader, outType, 股票数, resultByte深沪股票除权输出数据);
			//除权DataOutputBean飞狐 
			// 5、设置出力文件名
			String outFileName = PROPERTY.取得飞狐用导入数据文件名();
			outFileName = StringUtils.isEmpty(outFileName)?"historyDataForFeihuSoftWare": outFileName;

			// 6、写入文件
			write(PROPERTY.取得sh出力目录().concat("\\").concat(outFileName).concat(".".concat(s数据格式扩展名[Integer.parseInt(sOutPutDataType)])), outputTofile最终整合出力数据);

		}

	}

	/**
	 * 解析取到的深沪股票除权输出数据
	 * @param 除权数据list in  取到的除权数据
	 * @param header     out 输出用头文件
	 * @param type       out 输出用type
	 * @param i股票数    out 输出股票个数
	 * @param out除权dataOutputBean飞狐2
	 * @return
	 */
	private byte[] 解析取到的深沪股票除权输出数据(List<String> 除权数据list, int[] i股票数, 除权DataOutputBean飞狐 out除权dataOutputBean飞狐2) {
		/**
		 * 除权数据list是什么样子？
		 *
		 *	String =市场 证券代码 日期 权息数据类别 前流通盘或派息金额 前总股本或配股价 后流通盘或送股数 后总股本或配售数
			String =市场 证券代码 日期 权息数据类别 前流通盘或派息金额 前总股本或配股价 后流通盘或送股数 后总股本或配售数
					0 300486 20150630 5 0.000000 0.000000 3472.000000 13886.087891
					0 300486 20160421 5 3472.000000 13886.087891 3472.000000 14138.087891
					0 300486 20160616 1 1.100000 0.000000 0.000000 0.000000
					0 300486 20160701 5 3472.000000 14138.087891 8425.858398 14138.087891
					0 300486 20171012 5 8425.858398 14138.087891 8425.858398 14028.288086
					0 300486 20171231 5 8425.858398 14028.288086 8958.393555 14028.288086
					0 300486 20180411 5 8958.393555 14028.288086 8425.858398 16304.118164
					0 300486 20180529 1 0.250000 0.000000 0.000000 0.000000
					0 300486 20180630 5 8425.858398 16304.118164 13338.958008 16304.118164
					0 300486 20180702 5 13338.958008 16304.118164 13353.552734 16304.118164
					0 300486 20180911 5 13353.552734 16304.118164 13338.958008 16161.918945
					0 300486 20190129 5 13338.958008 16161.918945 13371.403320 18067.083984
					0 300486 20190630 5 13371.403320 18067.083984 13209.409180 18067.083984
					0 300486 20190703 1 0.350000 0.000000 0.000000 0.000000
		 */
		byte[] resultByte深沪股票除权输出数据 = new byte[0];
		byte[] 股票代码 = null;
		byte[] 除权数据个数 = null;

		// 对每一只股票的除权信息解析
       for(String in每股除权Data : 除权数据list) {
           System.out.println(in每股除权Data);
			// 解析文件返回出力内容
           除权DataOutputBean飞狐 out除权dataOutputBean飞狐 = new 除权DataOutputBean飞狐();
			// byte[] resultByteO一只股票 = 将入力文件的内容转成Byte (file, dayDataOutputBean飞狐);

			byte[] resultByteO一条 = StockData除权ConvertTool.解析每一行的除权数据(
					this.s最后交易日期,
					in每股除权Data,
					out除权dataOutputBean飞狐);

			// 【dayDataOutputBean飞狐】是从子函数里返回的值
			if(out除权dataOutputBean飞狐.getHeader() != null)out除权dataOutputBean飞狐2.setHeader(out除权dataOutputBean飞狐.getHeader());
			if(out除权dataOutputBean飞狐.getType() != null )out除权dataOutputBean飞狐2.setType(out除权dataOutputBean飞狐.getType());
           if(out除权dataOutputBean飞狐.getStockCode() != null) {
           	股票代码 = out除权dataOutputBean飞狐.getStockCode();
           }

			// 股票个数加1
           // 将解析完的数组相加
			if(resultByteO一条 != null && resultByteO一条.length > 1 ) {
				// 整合出力数据

				// 除权数据个数 = OutputDataUtil爸爸.convertInttoBytePublic(i除权数据个数);
				除权数据个数 = out除权dataOutputBean飞狐.get除权个数();
				resultByte深沪股票除权输出数据 = OutputDataUtil爸爸.数组合并2(
						resultByte深沪股票除权输出数据,
						out除权dataOutputBean飞狐.getStart(),
						股票代码,
						除权数据个数,
						resultByteO一条
						);

				i股票数[0] ++;
			}
       }

		return resultByte深沪股票除权输出数据;
	}

	public static byte[] 解析每一行的除权数据(String[] s最后交易日期, String s除权Data, 除权DataOutputBean飞狐 除权dataOutputBean飞狐) {
		/*=======================================
		|-----header			️
		|-----type
		|-----股票数
				|------股票代码
				|------除权数据
						|------送股-配股-配送股-分红
						|------送股-配股-配送股-分红
						|------送股-配股-配送股-分红
						|------送股-配股-配送股-分红

		=======================================*/

		/**
		 * s除权Data是什么样子？
		 *  <没有除权信息>
		 *	String =市场 证券代码 日期 权息数据类别 前流通盘或派息金额 前总股本或配股价 后流通盘或送股数 后总股本或配售数
		    <有除权信息>
			String =市场 证券代码 日期 权息数据类别 前流通盘或派息金额 前总股本或配股价 后流通盘或送股数 后总股本或配售数
					0 300486 20150630 5 0.000000 0.000000 3472.000000 13886.087891
					0 300486 20160421 5 3472.000000 13886.087891 3472.000000 14138.087891
					0 300486 20160616 1 1.100000 0.000000 0.000000 0.000000
					0 300486 20160701 5 3472.000000 14138.087891 8425.858398 14138.087891
					0 300486 20171012 5 8425.858398 14138.087891 8425.858398 14028.288086
					0 300486 20171231 5 8425.858398 14028.288086 8958.393555 14028.288086
					0 300486 20180411 5 8958.393555 14028.288086 8425.858398 16304.118164
					0 300486 20180529 1 0.250000 0.000000 0.000000 0.000000
					0 300486 20180630 5 8425.858398 16304.118164 13338.958008 16304.118164
					0 300486 20180702 5 13338.958008 16304.118164 13353.552734 16304.118164
					0 300486 20180911 5 13353.552734 16304.118164 13338.958008 16161.918945
					0 300486 20190129 5 13338.958008 16161.918945 13371.403320 18067.083984
					0 300486 20190630 5 13371.403320 18067.083984 13209.409180 18067.083984
					0 300486 20190703 1 0.350000 0.000000 0.000000 0.000000
		 */
		// 把数据分解成数组
		byte[] resultByte深沪个股除权输出数据 = new byte[0];
		String[] s每条除权数据 = s除权Data.split("\\n");
		int iIndex = 0;
		int i除权数据个数 = 0;
		for(String s每项除权数据  : s每条除权数据) {
			if(iIndex == 0) {
				iIndex++;
				continue;
			}

			// 从第二条开始分析
			String[] s = s每项除权数据.split("\\t");
			if (s.length != 8) return null;
			// 判断是不是实际的数据
			if(判断是不是有效的除权数据ForDLLData(s)) {
				// 只有实际的数据才进行后续处理
				// 先取得股票代号，做成文件名
				// 再取得入力的值
				// 输出实体文件

				// 先取得股票代号，做成文件名
				// 市场 证券代码 日期 权息数据类别 派息金额 配股价 送股数 配股数

				// 先取得股票代号，做成文件名
				String s市场       = s[0];
				String s股票代码 = s[1];
				String s日期      = s[2];
				String s权息数据类别= s[3];
				String s派息金额 = s[4];
				String s配股价   = s[5];
				String s送股数   = s[6];
				String s配股数   = s[7];
				String[] sData = new String[] {s市场, s股票代码,s日期,s权息数据类别,s派息金额,s配股价,s送股数,s配股数};
				/**
				 * 把每条除权数据进行拼接+组合
				 */
				byte[] 除权单条dataOutputBean飞狐 = get除权Byte(sData, 除权dataOutputBean飞狐);
				resultByte深沪个股除权输出数据  = OutputDataUtil爸爸.数组合并2(resultByte深沪个股除权输出数据, 除权单条dataOutputBean飞狐);
				i除权数据个数++;
				除权dataOutputBean飞狐.set除权个数(OutputDataUtil爸爸.convertInttoBytePublic(i除权数据个数));
			}
		}
		return resultByte深沪个股除权输出数据;
	}

	/**
	 * 判断是不是有效的除权数据ForDLLData
	 * @param s={市场 证券代码 日期 权息数据类别 派息金额 配股价 送股数 配股数}
	 * @return 如果 权息数据类别 == “1” return true;
	 *         如果 权息数据类别 != “1” return false;
	 */
	private static boolean 判断是不是有效的除权数据ForDLLData(String[] s) {
		// 市场 证券代码 日期 权息数据类别 派息金额 配股价 送股数 配股数
		if(s[3].equals("1")) {return true;}
		return false;
	}

	private static byte[] get除权Byte(String[] sData, 除权DataOutputBean飞狐 除权dataOutputBean飞狐) {
		OutputDataUtil飞狐  outputDataUtil = new OutputDataUtil飞狐();
		return outputDataUtil.getOutputData除权(sData, 除权dataOutputBean飞狐);
	}

	// 日期！，每次只取得一个日期的文件。
	public static void main(String[] args) {

		List<String> 除权数据list = InputDataUtil除权.getFileContext2("./通达信 除权数据.data");

		int[] outi股票数 = {0};
		除权DataOutputBean飞狐 out除权dataOutputBean飞狐 = new 除权DataOutputBean飞狐();
		byte[] resultByte深沪股票除权输出数据 = new StockData除权ConvertTool().解析取到的深沪股票除权输出数据( 除权数据list, outi股票数,out除权dataOutputBean飞狐);

		if(outi股票数[0] == 0) return; // 如果股票数为零，就退出
		byte[] 股票数 = null;
		if(股票数 == null)股票数 = OutputDataUtil爸爸.convertInttoBytePublic(outi股票数[0]);

		// 最终整合
		byte[] outputTofile最终整合出力数据 = new byte[0];
		outputTofile最终整合出力数据 = OutputDataUtil爸爸.数组合并(
				out除权dataOutputBean飞狐.getHeader(),
				out除权dataOutputBean飞狐.getType(),
				股票数,
				resultByte深沪股票除权输出数据
		);

		//String outFileName = PROPERTY.取得飞狐用导入数据文件名();
		//outFileName = StringUtils.isEmpty(outFileName)?"historyDataForFeihuSoftWare": outFileName;

		new StockDataOneDayConvertTool().write(PROPERTY.取得sh出力目录().concat("\\").concat("ftsplit.CQD"), outputTofile最终整合出力数据);
		//new StockDataOneDayConvertTool().write("/Users/haoyan/Desktop/FinanceDataConvert/ftsplit.CQD",outputTofile最终整合出力数据);

	}
}
