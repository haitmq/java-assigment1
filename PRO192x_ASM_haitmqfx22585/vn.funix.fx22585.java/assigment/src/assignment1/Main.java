package assignment1;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        mainProgram();
    }
//    tao main program chua cac chuong trinh con
    public static void mainProgram() {
        boolean reset = true;
        while (reset) {
            //        tao bang chon
            tableShow();
//        kiem tra ma xac thuc
            boolean CCCDFunc = verifyCheck();
//        neu nhap ma xac thuc dung thi moi thuc hien nhap ma CCCD
            if(CCCDFunc) {
//        Nếu chọn return sẽ quay trở lại menu thay vì thoát chương trình
               reset = checkCCCD();
            } else {
                reset = false;
            }
        }
    }
//    tao bang chon
    public static void tableShow() {
        final String AUTHOR = "FX22585@";
        final String VERSION = "v1.0.0";
        String rowLine = "+--------------+--------------------+--------------+%n";
        int rowLineLength = rowLine.length();
        String placeHolderStr = "| %-"+ (rowLineLength-6) +"s |%n";
        System.out.format(rowLine);
        System.out.format(placeHolderStr, "NGAN HANG SO | " + AUTHOR + "@" + VERSION);
        System.out.format(rowLine);
        System.out.format(placeHolderStr, "1. Nhap CCCD");
        System.out.format(placeHolderStr, "0. Thoat");
        System.out.format(rowLine);
    }
//    tao 1 ham sinh ra loi de su dung catch block
    public static void errorFunction () {
        System.out.println(1/0);
    }
//    ket thuc chuong trinh
    public static boolean exitProgram() {
        System.out.println("Ket thuc chuong trinh.");
        return false;
    }

//    tao ham check ma xac thuc
    public static boolean verifyCheck() {
//        tao doi tuong random su dung cho ma xac thuc
        Random rd = new Random();
//        tao chuoi alphabet string (su dung cho phan nang cao)
        String alphabet ="abcdefghjkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ123456789";
        int alLen = alphabet.length();

//          tao vong lap de yeu cau nguoi dung nhap lai neu khong chính xac
        do {
            System.out.print("Chuc nang: ");
            String funcChoose = sc.nextLine();
            if (!((funcChoose.equals("1"))||(funcChoose.equals("0")))) {
                System.out.println("Vui long nhap dung chuc nang");
                continue;
            }
            int intFuncChoose = Integer.parseInt(funcChoose);
            switch (intFuncChoose) {
                case 1:
                    System.out.println("Vui long chon hinh thuc bao mat.");
                    System.out.println("   | 1. EASY");
                    System.out.println("   | 2. HARD");
                    System.out.println("   | 0. Thoat");
//                    su dung try catch block de bat loi input
                    while(true) {
                        try {
                            System.out.print("Chon hinh thuc bao mat: ");
                            String sercuryLevel = sc.nextLine();
//                         error ocur neu input khong phai la number
                            int intSercuryLevel = Integer.parseInt(sercuryLevel);
//                        error occur neu input khong nam trong cac chuc nang
                            if((intSercuryLevel < 0) || (intSercuryLevel > 2)) {
                                errorFunction();
                            }
//                        thoat chuong trinh
                            if (intSercuryLevel == 0) {
                                return exitProgram();
                            }
                            do {
//                                tao gia tri ban dau cho ma xac thuc
                                String verifiCodes ="";
                                switch (intSercuryLevel) {
                                    case 1:
//                                        hinh thuc xac thuc easy
//                                        tao chuoi 3 so bat ki tu 100->999
                                        verifiCodes += (rd.nextInt(900) +100);
                                        break;
                                    case 2:
//                                        hinh thuc xac thuc hard (nâng cao)
//                                        tao vong lap lay 6 ky tu bat ki tu chuoi alphabet
                                        for (int i =0; i<6; i++) {
                                            int ind = rd.nextInt(alLen);
                                            verifiCodes += alphabet.substring(ind,ind+1);
                                        }
                                        break;
                                }
                                System.out.println("Nhap ma xac thuc: "+ verifiCodes);
                                System.out.print("Xac thuc: ");
                                String verifiInput = sc.nextLine();
//                                kiem tra ma xac thuc voi input cua user
                                if (verifiInput.equals(verifiCodes)) {
                                    System.out.println("Da xac thuc");
//                                    neu dung thoat khoi phuong thuc nay va thuc hien phuong thuc kiem tra CCCD
                                    return true;
                                } else if ((verifiInput.toLowerCase()).equals("no")) {
                                    return exitProgram();
                                } else {
                                    System.out.println("Ma xac thuc khong chinh xac.");
                                    System.out.println("Vui long nhap lai hoac 'No' de thoat");
                                }
                            } while (true);
                        }
                        catch (Exception e) {
                            System.out.println("Lua chon khong dung. Vui long thu lai.");
                        }
                    }
                case 0:
                    return exitProgram();
            }
        } while (true);
    }
    public static boolean checkCCCD() {
//        tao mang 2 chieu chua ma vung va ten vung
        String [][] areaCode = {{"001", "Ha Noi"},{"002", "Ha Giang"}, {"004", "Cao Bang"},
                {"006", "Bac Can"}, {"008", "Tuyen Quang"}, {"010", "Lao Cai"}, {"011", "Dien Bien"},
                {"012", "Lai Chau"}, {"014", "Son La"}, {"015", "Yen Bai"}, {"017", "Hoa Binh"},
                {"019", "Thai Nguyen"}, {"020", "Lang Son"}, {"022", "Quang Ninh"}, {"024", "Bac Giang"},
                {"025", "Phu Tho"}, {"026", "Vinh Phuc"}, {"027", "Bac Ninh"}, {"030", "Hai Duong"},
                {"031", "Hai Phong"}, {"033", "Hung Yen"}, {"034", "Thai Binh"}, {"035", "Ha Nam"},
                {"036", "Nam Dinh"}, {"037", "Ninh Binh"}, {"038", "Thanh Hoa"}, {"040", "Nghe An"},
                {"042", "Ha Tinh"},{"044", "Quang Binh"}, {"045", "Quang Tri"}, {"046", "Thua Thien Hue"},
                {"048", "Da Nang"}, {"049", "Quang Nam"}, {"051", "Quang Ngai"}, {"052", "Binh Dinh"},
                {"054", "Phu Yen"}, {"056", "Khanh Hoa"}, {"058", "Ninh Thuan"}, {"060", "Binh Thuan"},
                {"062", "Kom Tum"}, {"064", "Gia Lai"}, {"066", "Dak Lak"}, {"067", "Dak Nong"},
                {"068", "Lam Dong"}, {"070", "Binh Phuoc"}, {"072", "Tay Ninh"}, {"074", "Binh Duong"},
                {"075", "Dong Nai"}, {"077", "Ba Ria - Vung Tau"}, {"079", "Ho Chi Minh"}, {"080", "Long An"},
                {"082", "Tien Giang"}, {"083", "Ben Tre"}, {"084", "Tra Vinh"}, {"086", "Vinh Long"},
                {"087", "Dong Thap"}, {"089", "An Giang"}, {"091", "Kien Giang"}, {"092", "Can Tho"},
                {"093", "Hau Giang"}, {"094", "Soc Trang"}, {"095", "Bac lieu"}, {"096", "Ca Mau"}};
//        tao mang 2 chieu chua gioi tinh va the ky
        int [][] gendAndBYear = {{0,19},{2,20},{4,21},{6,22},{8,23}};
        int lenArea = areaCode.length;
//      tạo biến logic để thoát vòng lặp ngoài cùng
        boolean logicCheck = true;
        String cccdCode;
//        tao bien luu ten vung;
        String province = "";

        System.out.print("Vui long nhap so CCCD: ");
        while(logicCheck) {
            cccdCode = sc.nextLine();
            if((cccdCode.toLowerCase()).equals("no")) {
                return exitProgram();
            }
            try {
//                kiem tra xem mã CCCD có là 1 chuỗi số hay không
                long longCCCDCode = Long.parseLong(cccdCode);
//                tao bien boolean de kiểm tra 3 chữ số đầu của mã CCCD có nằm trong 63 mã vùng hay không
                boolean isInAreaCode = false;
//                lặp qua 63 mã vùng nếu khớp thì isInAreaCode trả về true và thoát khỏi vòng lặp
                for(int i =0; i<lenArea; i++) {
                    if((cccdCode.substring(0,3).equals(areaCode[i][0]))){
                        isInAreaCode = true;
                        province += areaCode[i][1];
                        break;
                    }
                }
//                  kiểm tra nếu mã CCCD có độ dài không bằng 12 hoặc không nằm trong 63 mã vùng thì tạo lỗi để catch
                if((cccdCode.length() != 12) || (!isInAreaCode)) {
                    errorFunction();
                }

                //        Sau khi nhập 1 mã CCCD hợp lệ
                do {
                    try {
                        System.out.println("   | 1. Kiem tra noi sinh");
                        System.out.println("   | 2. Kiem tra tuoi, gioi tinh");
                        System.out.println("   | 3. Kiem tra so ngau nhien");
                        System.out.println("   | 4. Tro lai menu");
                        System.out.println("   | 0. thoat");
                        System.out.print("Chuc nang: ");
                        String funcChoose = sc.nextLine();
//                        tạo lỗi nếu không phải là số
                        int intFuncChoose = Integer.parseInt(funcChoose);
//                        nếu không nằm trong phạm vi chức năng thì tạo lỗi
                        if ((intFuncChoose > 4) || (intFuncChoose < 0 )) {
                            errorFunction();
                        }
//                        thoat chương trinh
                        if (intFuncChoose == 0 ){
                            logicCheck = false;
                            return exitProgram();
                        }
                        switch (intFuncChoose) {
                            case 1:
//                                hiển thị nơi sinh
                                System.out.println("Noi sinh: " + province);
                                break;
                            case 2:
//                                tạo biến lấy giới tính từ mã CCCD
                                int gender = Integer.parseInt(cccdCode.substring(3,4));
                                for (int i = 0; i < gendAndBYear.length;i++) {
                                    if(gender == gendAndBYear[i][0]) {
                                        System.out.println("Gioi tinh: Nam | " + gendAndBYear[i][1] + cccdCode.substring(4,6));
                                    } else if ((gender -1)== gendAndBYear[i][0]) {
                                        System.out.println("Gioi tinh: Nu | " + gendAndBYear[i][1] + cccdCode.substring(4,6));
                                    }
                                }
                                break;
                            case 3:
//                                hien thi chuoi so ngau nhien
                                System.out.println("So ngau nhien: " + cccdCode.substring(6));
                                break;
                            case 4:
                                return true;
                        }
                    }
                    catch (Exception e) {
//                        yêu cầu user nhap lai nếu có lỗi
                        System.out.println("Chuc nang khong ton tai. Vui long nhap lai.");
                    }
                } while (true);
            } catch (Exception e) {
                System.out.println("So CCCD khong hop le.");
                System.out.print("Vui long nhap lai hoac 'No' de thoat: ");
            }
        }
        return false;
    }
}