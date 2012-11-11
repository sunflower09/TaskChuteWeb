package jp.sunflower09.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 範囲選択を行うためのユーティリティ
 * 
 * @author cyubachi
 * 
 */
public class RowSelector {
	/**
	 * カンマ区切りを示す正規表現文字列
	 */
	private static final String TOKENISER_BY_COMMA_REGEX = ",";

	/**
	 * ハイフン無し、一桁以上の数値を示す正規表現文字列
	 */
	private static final Pattern SINGLE_TOKEN_REGEX = Pattern
			.compile("^[0-9]+$");

	/**
	 * ハイフン有り、一桁以上の数値を示す正規表現文字列
	 */
	private static final Pattern HYPHEN_TOKEN_REGEX = Pattern
			.compile("^([0-9]+)-([0-9]+)$");

	/**
	 * セットに加える基準となる数値
	 */
	private static final int ADDABLE_ZERO_NUM = 0;

	/**
	 * 引数の範囲選択文字列が示す行数を返却する。
	 * 
	 * @param selectText
	 *            範囲選択文字列
	 * @return 行数
	 */
	public static int getSelectCount(String selectText) {
		int count = 0;
		if (!StringUtils.isBlank(selectText)) {
			count = getUniqueRowNum(selectText).size();
		}
		return count;
	}

	/**
	 * 取得すべき行についての情報を返却する。<br>
	 * 返却するSelectInfoが保持するのは、開始行(カウントは0スタート)、終了行、行数。
	 * 
	 * @param selectText
	 *            範囲選択文字列
	 * @return 取得すべき行についての情報リスト
	 */
	public static List<SelectRowsInfo> getSelectRowInfo(String selectText) {
		List<SelectRowsInfo> selectInfoList = new ArrayList<SelectRowsInfo>();
		if (StringUtils.isBlank(selectText)) {
			return selectInfoList;
		}
		Set<Integer> rowNumsSet = getUniqueRowNum(selectText);
		SelectRowsInfo currentInfo = null;
		for (int num : rowNumsSet) {
			if (currentInfo == null) {
				currentInfo = new SelectRowsInfo(num);
				selectInfoList.add(currentInfo);
			} else {
				int nextNum = currentInfo.getEnd() + 1;
				if (num == nextNum) {
					currentInfo.increment();
				} else {
					currentInfo = new SelectRowsInfo(num);
					selectInfoList.add(currentInfo);
				}
			}
		}
		return selectInfoList;
	}

	/**
	 * 引数の範囲選択文字列を解釈し、対象となる行番号をソートされた一意のセットにして返す。<br>
	 * カウントは0から開始する。0未満の値は除去する。
	 * 
	 * @param selectText
	 *            範囲選択文字列
	 * @return 取得すべき行番号のセット
	 */
	private static Set<Integer> getUniqueRowNum(String selectText) {
		String[] separatedArray = selectText.split(TOKENISER_BY_COMMA_REGEX);
		Set<Integer> rowNumsSet = new TreeSet<Integer>();
		for (String token : separatedArray) {
			Matcher singleTokenMatcher = SINGLE_TOKEN_REGEX.matcher(token);
			if (singleTokenMatcher.matches()) {
				addToSet(rowNumsSet, Integer.parseInt(token));
			}
			Matcher hyphenTokenMatcher = HYPHEN_TOKEN_REGEX.matcher(token);
			if (hyphenTokenMatcher.matches()) {
				int left = Integer.parseInt(hyphenTokenMatcher.group(1));
				int right = Integer.parseInt(hyphenTokenMatcher.group(2));
				int minor, major = 0;
				if (left <= right) {
					minor = left;
					major = right;
				} else {
					minor = right;
					major = left;
				}
				for (int i = minor; i <= major; i++) {
					addToSet(rowNumsSet, i);
				}
			}
		}
		return rowNumsSet;
	}

	/**
	 * 第一引数のセットに第二引数の数値を追加する。<br>
	 * 追加する際、値は-1する。また、0以上の数値しかセットに追加されない。
	 * 
	 * @param selectText
	 *            範囲選択文字列
	 * @return 取得すべき行番号のセット
	 */
	private static void addToSet(Set<Integer> rowNumsSet, int num) {
		if (num > ADDABLE_ZERO_NUM) {
			rowNumsSet.add(num - 1);
		}
	}

	/**
	 * 取得対象となる一塊の検索結果についての情報を保持するクラス
	 */
	public static class SelectRowsInfo {

		/**
		 * 取得対象の開始行（0からカウント）
		 */
		private int start;

		/**
		 * 取得対象の終了行（0からカウント）
		 */
		private int end;

		/**
		 * 取得対象の行数
		 */
		private int rows;

		/**
		 * コンストラクタ。引数の数値を開始行と終了行にセットする。
		 */
		public SelectRowsInfo(int num) {
			this.start = num;
			this.end = num;
			this.rows = 1;
		}

		/**
		 * 開始行の取得
		 * 
		 * @return 開始行
		 */
		public int getStart() {
			return start;
		}

		/**
		 * 終了行の取得
		 * 
		 * @return 終了行
		 */
		public int getEnd() {
			return end;
		}

		/**
		 * 行数の取得
		 * 
		 * @return 行数
		 */
		public int getRows() {
			return rows;
		}

		/**
		 * 終了行と行数のインクリメント
		 */
		public void increment() {
			this.end++;
			this.rows++;
		}
	}
}
