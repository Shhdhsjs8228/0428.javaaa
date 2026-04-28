/**
 * Java 程式設計(一) Assignment 1: Probability
 * 依據講義 13 個獨立小節建立對應類別
 */

// 1. 機率的定義 [cite: 21, 22]
class ProbDefinition {
    public void display() { System.out.println("1. 機率表示某件事情發生的可能性。"); }
}

// 2. 樣本空間 (Sample Space) [cite: 25, 26]
class SampleSpace {
    String S = "所有可能結果的集合";
    public void display() { System.out.println("2. 樣本空間 S: " + S); }
}

// 3. 事件 (Event) [cite: 29, 30]
class ProbabilityEvent {
    String A = "我們關心的事件";
    public void display() { System.out.println("3. 事件 A: " + A); }
}

// 4. 基本公式 [cite: 32, 33, 34]
class BasicFormula {
    public double calculate(double nA, double nS) {
        return nA / nS; // 口訣：我要的/全部的
    }
}

// 5. 補事件 [cite: 38, 36]
class ComplementEvent {
    public double getNotA(double pA) {
        return 1 - pA; // P(A^C) = 1 - P(A)
    }
}

// 6. 聯集 (OR) [cite: 40, 41]
class UnionEvent {
    public double getUnion(double pA, double pB, double pIntersect) {
        return pA + pB - pIntersect; // P(A∪B)
    }
}

// 7. 交集 (AND) [cite: 51, 52]
class IntersectEvent {
    public double getIntersect(double pA, double pBGivenA) {
        return pA * pBGivenA; // P(A∩B) = P(A)P(B|A)
    }
}

// 8. 條件機率 [cite: 67, 66]
class ConditionalProbability {
    public double getProb(double pIntersect, double pB) {
        return pIntersect / pB; // P(A|B) = P(A∩B)/P(B)
    }
}

// 9. 獨立事件 [cite: 79, 78]
class IndependentEvent {
    public boolean check(double pA, double pB, double pIntersect) {
        return Math.abs(pIntersect - (pA * pB)) < 0.001; // P(A∩B) = P(A)P(B)
    }
}

// 10. 貝氏定理 [cite: 87]
class BayesTheorem {
    public double inverse(double pBGivenA, double pA, double pB) {
        return (pBGivenA * pA) / pB; // 已知結果，反推原因
    }
}

// 11. 全機率公式 [cite: 89]
class TotalProbability {
    public double sum(double[] pAGivenBi, double[] pBi) {
        double total = 0;
        for (int i = 0; i < pBi.length; i++) total += pAGivenBi[i] * pBi[i];
        return total;
    }
}

// 12. 學校例子 [cite: 90]
class SchoolStats {
    public void print(double J, double B, double N) {
        System.out.println("12. P(建中)=" + (J/N) + ", P(北一女)=" + (B/N));
    }
}

// 13. 建中或北一女 (互斥) [cite: 91]
class MutualExclusive {
    public double getUnion(double J, double B, double N) {
        return (J + B) / N; // 因為兩者互斥
    }
}

// --- 執行類別 ---
public class ProbabilityAssignment {
    public static void main(String[] args) {
        System.out.println("=== 講義 13 題獨立物件輸出 ===\n");

        new ProbDefinition().display();
        new SampleSpace().display();
        new ProbabilityEvent().display();
        
        System.out.println("4. 基本公式 P(A): " + new BasicFormula().calculate(30, 100));
        System.out.println("5. 補事件機率: " + new ComplementEvent().getNotA(0.3));
        System.out.println("6. 聯集 P(A∪B): " + new UnionEvent().getUnion(0.53, 0.45, 0.20));
        System.out.println("7. 交集 P(A∩B): " + new IntersectEvent().getIntersect(0.60, 0.35));
        System.out.println("8. 條件機率 P(A|B): " + String.format("%.2f", new ConditionalProbability().getProb(0.30, 0.65)));
        System.out.println("9. 是否為獨立事件: " + new IndependentEvent().check(0.6, 0.45, 0.27));
        System.out.println("10. 貝氏定理計算: " + new BayesTheorem().inverse(0.35, 0.6, 0.45));
        
        double[] pa_bi = {0.8, 0.5};
        double[] pb = {0.4, 0.6};
        System.out.println("11. 全機率結果: " + new TotalProbability().sum(pa_bi, pb));
        
        new SchoolStats().print(50, 40, 200);
        System.out.println("13. 建中或北一女機率: " + new MutualExclusive().getUnion(50, 40, 200));
    }
}