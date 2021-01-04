package ikguana.all.universalapis.papyrus

import ikguana.all.universalapis.UniversalAPI

//API for logs
object Papyrus : UniversalAPI() {

//    public static void saveLog(String fname, String data) {
//        logFolder.mkdirs();
//        (new File(logFolder, fname)).mkdirs();
//
//        String yyyyMMdd = new SimpleDateFormat("yyyyMMdd", Locale.KOREA).format(new Date());
//        String kkMM = new SimpleDateFormat("kk:MM", Locale.KOREA).format(new Date());
//
//        File file = new File(logFolder, fname + File.separator + yyyyMMdd + ".txt");
//        try {
//            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)), true);
//            writer.println(kkMM + " " + data);
//            writer.close();
//        } catch (Exception err) {
//            err.printStackTrace();
//        }
}