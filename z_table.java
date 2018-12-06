public class z_table {
        private static double erf(double x) {
                // A&S formula 7.1.26
                double a1 = 0.254829592;
                double a2 = -0.284496736;
                double a3 = 1.421413741;
                double a4 = -1.453152027;
                double a5 = 1.061405429;
                double p = 0.3275911;
                x = Math.abs(x);
                double t = 1 / (1 + p * x);
                // Direct calculation using formula 7.1.26 is absolutely correct
                // But calculation of nth order polynomial takes O(n^2) operations
                // return 1 - (a1 * t + a2 * t * t + a3 * t * t * t + a4 * t * t * t * t + a5 *
                // t * t * t * t * t) * Math.Exp(-1 * x * x);

                // Horner's method, takes O(n) operations for nth order polynomial
                return 1 - ((((((a5 * t + a4) * t) + a3) * t + a2) * t) + a1) * t * Math.exp(-1 * x * x);
        }

        public static double NORMSDIST(double z) {
                double sign = 1;
                if (z < 0)
                        sign = -1;

                double result = 0.5 * (1.0 + sign * erf(Math.abs(z) / Math.sqrt(2)));
                return result;
        }

        public static void main(String[] args) {

                System.out.println();

                System.out.print("| z    ");

                for (double i = 0.0; i < .1 - .01; i += .01) {
                        System.out.printf("| %.16f ", i);
                }

                System.out.println();

                System.out.println(
                                "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                for (double i = 0.00; i <= 5.00; i += .1) {
                        double c1  = (NORMSDIST(i) - NORMSDIST(0));
                        double c2  = (c1 + NORMSDIST(i + .1) - NORMSDIST(0));
                        double c3  = (c2 + NORMSDIST(i + .1) - NORMSDIST(0));
                        double c4  = (c3 + NORMSDIST(i + .1) - NORMSDIST(0));
                        double c5  = (c4 + NORMSDIST(i + .1) - NORMSDIST(0));
                        double c6  = (c5 + NORMSDIST(i + .1) - NORMSDIST(0));
                        double c7  = (c6 + NORMSDIST(i + .1) - NORMSDIST(0));
                        double c8  = (c7 + NORMSDIST(i + .1) - NORMSDIST(0));
                        double c9  = (c8 + NORMSDIST(i + .1) - NORMSDIST(0));
                        double c10 = (c9 + NORMSDIST(i + .1) - NORMSDIST(0));

                        // columns 3-10 werent in the right place so this shifted them one spot to the right.
                        double c30 = c3*.1;
                        double c40 = c4*.1;
                        double c50 = c5*.1;
                        double c60 = c6*.1;
                        double c70 = c7*.1;
                        double c80 = c8*.1;
                        double c90 = c9*.1;
                        double c100 = c10*.1;

                        System.out.printf("| %.2f ", i);
                        System.out.printf("| %.16f ", c1);
                        System.out.printf("| %.16f ", c2);
                        System.out.printf("| %.16f ", c30);
                        System.out.printf("| %.16f ", c40);
                        System.out.printf("| %.16f ", c50);
                        System.out.printf("| %.16f ", c60);
                        System.out.printf("| %.16f ", c70);
                        System.out.printf("| %.16f ", c80);
                        System.out.printf("| %.16f ", c90);
                        System.out.printf("| %.16f \n", c100);
                }

        }

}