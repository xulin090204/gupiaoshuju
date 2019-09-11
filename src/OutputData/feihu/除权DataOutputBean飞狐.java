package OutputData.feihu;

import lombok.Data;

@Data
public class 除权DataOutputBean飞狐 {
	byte[] header;			// header : d6ff ffff
	byte[] type;			// type   : 0000 0001
	byte[] stockCount;		// 股票数 : 0000 0001
	byte[] start;			// size=8 : ffff ffff
	byte[] stockCode;		// size=24 : 535a 3030 3030 3031 0000 0000
	byte[] 除权个数;			// 除权个数  : 0000 0001
	byte[] UTCtime;			// 除权日      : 5cc2 4a00
	byte[] 送股;			// 送股   : 0000 0000 * 10
	byte[] 配股;			// 配股   : 0000 003F * 10
	byte[] 配送股;			// 配送股 : 0000 0041 * 1
	byte[] 分红;				// 分红          : cdcc 4c3e * 10
}
