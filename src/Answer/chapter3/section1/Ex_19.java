package Answer.chapter3.section1;

import Answer.base.Answer0;
import data_structure.st.BinarySearchOrderST;
import data_structure.st.ST;
import util.algorithms.FrequencyCounter;

import java.io.FileNotFoundException;

/**
 */
public class Ex_19 extends Answer0{
    @Override
    public void answer() {
        try {
            new FrequencyCounter() {
                @Override
                public ST getST() {
                    return new BinarySearchOrderST();
                }
            }.execute(0,"Ex_19.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
