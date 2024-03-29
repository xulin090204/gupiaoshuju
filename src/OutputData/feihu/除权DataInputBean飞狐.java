package OutputData.feihu;

import lombok.Data;

@Data
public class 除权DataInputBean飞狐 {

	private int header;			// header : d6ff ffff
	private int type;			// type   : 0000 0001
	private int stockCount;		// 股票数  : 0000 0001

	private int start;			// size=8 : ffff ffff
	private char[] stockCode;		// size=24 : 535a 3030 3030 3031 0000 0000
	private int 除权个数;			// 除权个数  : 0000 0001

	private int UTCtime;		// 除权日 : 5cc2 4a00
	private float 送股;			// 送股   : 0000 0000 * 10
	private float 配股;			// 配股   : 0000 003F * 10
	private float 配股价;			// 配股价 : 0000 0041 * 1
	private float 分红;			// 分红   : cdcc 4c3e * 10

}
