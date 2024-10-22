package phone;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class phone {
    // 電話帳を管理する HashMap
    private static Map<String, String> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // アプリケーションループ
        while (running) {
            showMenu();  // メニューを表示
            System.out.print("操作を選んでください: ");
            String choice = scanner.nextLine();  // ユーザーの選択を取得

            switch (choice) {
                case "1":
                    addEntry(scanner);  // 新しい登録
                    break;
                case "2":
                    searchEntry(scanner);  // 電話帳検索
                    break;
                case "3":
                    deleteEntry(scanner);  // 電話帳削除
                    break;
                case "4":
                    showAllEntries();  // 全てのエントリを表示
                    break;
                case "5":
                    System.out.println("アプリケーションを終了します。");
                    running = false;  // アプリケーション終了
                    break;
                default:
                    System.out.println("無効な選択です。もう一度選んでください。");
            }
        }
        scanner.close();
    }

    // メニューを表示するメソッド
    private static void showMenu() {
        System.out.println("\n===== 電話帳メニュー =====");
        System.out.println("1. 電話帳に登録");
        System.out.println("2. 電話帳から検索");
        System.out.println("3. 電話帳から削除");
        System.out.println("4. 電話帳の全件表示");
        System.out.println("5. アプリケーションを終了");
    }

    // 電話帳に新しい登録を追加するメソッド
    private static void addEntry(Scanner scanner) {
        System.out.print("登録する名前を入力してください: ");
        String name = scanner.nextLine();
        System.out.print("登録する電話番号を入力してください: ");
        String phoneNumber = scanner.nextLine();

        // HashMapに登録
        phoneBook.put(name, phoneNumber);
        System.out.println("登録完了: " + name + " (" + phoneNumber + ")");
    }

    // 名前で電話帳を検索するメソッド
    private static void searchEntry(Scanner scanner) {
        System.out.print("検索する名前を入力してください: ");
        String name = scanner.nextLine();

        // HashMapから検索
        if (phoneBook.containsKey(name)) {
            System.out.println(name + " の電話番号: " + phoneBook.get(name));
        } else {
            System.out.println(name + " は電話帳に存在しません。");
        }
    }

    // 名前で電話帳から削除するメソッド
    private static void deleteEntry(Scanner scanner) {
        System.out.print("削除する名前を入力してください: ");
        String name = scanner.nextLine();

        // HashMapから削除
        if (phoneBook.containsKey(name)) {
            phoneBook.remove(name);
            System.out.println(name + " を電話帳から削除しました。");
        } else {
            System.out.println(name + " は電話帳に存在しません。");
        }
    }

    // 電話帳の全ての登録を表示するメソッド
    private static void showAllEntries() {
        if (phoneBook.isEmpty()) {
            System.out.println("電話帳は空です。");
        } else {
            System.out.println("\n===== 電話帳全件一覧 =====");
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                System.out.println("名前: " + entry.getKey() + " | 電話番号: " + entry.getValue());
            }
        }
    }
}
