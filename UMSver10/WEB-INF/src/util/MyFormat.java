package util;



//インポート宣言
import java.text.*;

public class MyFormat {

	/**
	 * @メソッド名	：moneyFormat
	 * @説明		：金額(整数値)を受取り「\」付き「,」区切り
	 * @param		：int		money		：金額
	 * @return		：String	formatMoney	：(\XXX,XXX)形式に変換された金額
	 */
	public String moneyFormat(int money)
	{
		//フォーマットオブジェクト宣言
		NumberFormat exObject = NumberFormat.getCurrencyInstance();

		//金額の表示形式に変換
		String formatMoney = exObject.format(money);

		return formatMoney;

	}

}
