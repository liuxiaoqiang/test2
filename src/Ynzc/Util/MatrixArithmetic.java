package Ynzc.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class MatrixArithmetic {
	public MatrixArithmetic() {
	}

	public static String[] randomStr = { "A0", "A1", "A2", "A3", "A4", "A5",
			"A6", "A7", "B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "C0",
			"C1", "C2", "C3", "C4", "C5", "C6", "C7", "D0", "D1", "D2", "D3",
			"D4", "D5", "D6", "D7", "E0", "E1", "E2", "E3", "E4", "E5", "E6",
			"E7", "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "G0", "G1",
			"G2", "G3", "G4", "G5", "G6", "G7", "H0", "H1", "H2", "H3", "H4",
			"H5", "H6", "H7" };

	public static boolean compare(String checkcode, String rand) {
		int i = MatrixArithmetic.randomStr.length;
		boolean bool1 = false;
		boolean bool2 = false;
		HashMap<String, String> hashMap = new HashMap<String, String>(64);
		try {
			if (checkcode.length() < 6 || rand.length() < 4) {
				return false;
			}
			hashMap.put("A0", "778");
			hashMap.put("A1", "546");
			hashMap.put("A2", "778");
			hashMap.put("A3", "674");
			hashMap.put("A4", "436");
			hashMap.put("A5", "236");
			hashMap.put("A6", "754");
			hashMap.put("A7", "363");
			hashMap.put("B0", "976");
			hashMap.put("B1", "527");
			hashMap.put("B2", "964");
			hashMap.put("B3", "235");
			hashMap.put("B4", "975");
			hashMap.put("B5", "468");
			hashMap.put("B6", "943");
			hashMap.put("B7", "327");

			hashMap.put("C0", "259");
			hashMap.put("C1", "473");
			hashMap.put("C2", "856");
			hashMap.put("C3", "802");
			hashMap.put("C4", "477");
			hashMap.put("C5", "955");
			hashMap.put("C6", "675");
			hashMap.put("C7", "763");

			hashMap.put("D0", "075");
			hashMap.put("D1", "201");
			hashMap.put("D2", "390");
			hashMap.put("D3", "570");
			hashMap.put("D4", "121");
			hashMap.put("D5", "179");
			hashMap.put("D6", "519");
			hashMap.put("D7", "322");

			hashMap.put("E0", "633");
			hashMap.put("E1", "108");
			hashMap.put("E2", "285");
			hashMap.put("E3", "355");
			hashMap.put("E4", "833");
			hashMap.put("E5", "611");
			hashMap.put("E6", "900");
			hashMap.put("E7", "339");

			hashMap.put("F0", "204");
			hashMap.put("F1", "651");
			hashMap.put("F2", "909");
			hashMap.put("F3", "809");
			hashMap.put("F4", "307");
			hashMap.put("F5", "455");
			hashMap.put("F6", "235");
			hashMap.put("F7", "835");

			hashMap.put("G0", "575");
			hashMap.put("G1", "511");
			hashMap.put("G2", "222");
			hashMap.put("G3", "708");
			hashMap.put("G4", "068");
			hashMap.put("G5", "481");
			hashMap.put("G6", "260");
			hashMap.put("G7", "803");

			hashMap.put("H0", "886");
			hashMap.put("H1", "627");
			hashMap.put("H2", "557");
			hashMap.put("H3", "745");
			hashMap.put("H4", "833");
			hashMap.put("H5", "327");
			hashMap.put("H6", "294");
			hashMap.put("H7", "229");

			/*System.out.println("codesub1----------------------------"
					+ rand.toString().substring(0, 2));
			System.out.println("codesub2----------------------------"
					+ rand.toString().substring(2, 4));*/
			// ����Entry��������HashMap
			/*System.out.println("checkcode1------"
					+ checkcode.toString().substring(0, 3));
			System.out.println("checkcode2------"
					+ checkcode.toString().substring(3, 6));*/
			if (hashMap != null) {
				for (Entry<String, String> entry : hashMap.entrySet()) {
					// ������ֵ
					/*
					 * Iterator iterator = hashMap.keySet().iterator(); while
					 * (iterator.hasNext()) { Entry entry = (Entry)
					 * iterator.next();
					 */
					/*System.out.println("checkcode11------"
							+ checkcode.toString().substring(0, 3));
					System.out.println("checkcode22------"
							+ checkcode.toString().substring(3, 6));*/
					if (rand.toString().substring(0, 2).equals(entry.getKey())
							&& checkcode.toString().substring(0, 3).equals(
									entry.getValue())) {
						bool1 = true;
					}
					if (rand.toString().substring(2, 4).equals(entry.getKey())
							&& checkcode.toString().substring(3, 6).equals(
									entry.getValue())) {
						bool2 = true;
					}
				}
				// }
			}
			if (bool1 && bool2) {
				return true;
			} else {
				return false;
			}
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		}
	}
}
