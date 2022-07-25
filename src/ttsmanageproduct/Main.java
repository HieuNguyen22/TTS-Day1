/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ttsmanageproduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Category;
import model.Product;

/**
 *
 * @author Avada Kedavra
 */
public class Main {

    // Initialize list of data
    private static List<Product> pList;
    private static List<Category> cList;

    public static void main(String[] args) {

// -------- 2. ARRAY -----------
        int[] A = {1, 3, 5, 7, 8};

        System.out.println("2. Cau truc du lieu mang");
        // Insert
        System.out.println("---- Insert");
        insertArray(A, 100, 300);

        // Delete
        System.out.println("---- Delete");
        deleteArray(A, 300);

        // Search
        System.out.println("---- Search");
        searchArray(A, 1000);

// -------- PRODUCT -----------
        System.out.println("----- PRODUCT -----");
        // Import data
        importDataProduct();
        importDataCategory();

        // Get product by name
        System.out.println("4. Tim kiem Product bang ten");

        String requestName = "Main"; // Tim product co ten la "Main"
        List<Product> pGetByName = findProduct(pList, requestName);
        showResult(pGetByName, 1);

        // Get product by CateID
        System.out.println("5. Tim kiem Product bang CateID");

        int requestCateID = 2; // Tim product co Category ID = 2
        List<Product> pGetByCateID = findProductByCategory(pList, requestCateID);
        showResult(pGetByCateID, 2);

        // Get product by Price
        System.out.println("6. Tim kiem Product bang Gia");

        int requestPrice = 700; // Tim product co gia <= 700
        List<Product> pGetByPrice = findProductByPrice(pList, requestPrice);
        showResult(pGetByCateID, 3);

// -------- SORT -----------
        System.out.println("----- SORT -----");

        // 8. Bubble sort
        System.out.println("8. Bubble sort\n");
        int arrBubble[] = {5, 1, 4, 2, 8};
        System.out.println("Mảng ban đầu:");
        for (int i : arrBubble) {
            System.out.print(i + " ");
        }
        System.out.println();

        bubbleSort(arrBubble);

        System.out.println("Mảng sau khi sắp xếp:");
        for (int i : arrBubble) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        // 9. Insertion sort
        System.out.println("9. Insertion sort\n");
        int arrInsertion[] = {10, 9, 12, 13, 1, 2, 5, 3, 7};
        System.out.println("Mảng ban đầu:");
        for (int i : arrInsertion) {
            System.out.print(i + " ");
        }
        System.out.println();

        insertionSort(arrInsertion);

        System.out.println("Mảng sau khi sắp xếp:");
        for (int i : arrInsertion) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        // 10. Selection sort
        System.out.println("10. Selection sort\n");
        int arrSelection[] = {5, 7, 1, 3, 9, 10, 11, 22, 33};
        System.out.println("Mảng ban đầu:");
        for (int i : arrSelection) {
            System.out.print(i + " ");
        }
        System.out.println();

        selectionSort(arrSelection);

        System.out.println("Mảng sau khi sắp xếp:");
        for (int i : arrSelection) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        // 11. Sort by price
        System.out.println("11. Sap xep Product theo gia su dung Bubble Sort");
        sortByPrice(pList);

        // 12. Sort by name
        System.out.println("12. Sap xep Product theo ten su dung Insertion Sort");
        sortByName(pList);

        // 13. Sort by category name
        System.out.println("13. Sap xep Product theo Category Name su dung Insertion Sort");
        sortByCateName(pList, cList);

        // 14. Map product by Category
        System.out.println("14. Tra ve danh sach Product + Category Name");
        mapProductByCate(pList, cList);

        // 15. Get min price
        System.out.println("15. Tim product co gia nho nhat");
        minByPrice(pList);

        // 16. Get max price
        System.out.println("16. Tim product co gia lon nhat");
        maxByPrice(pList);

        // 21. Calculate salary
        System.out.println("21. Tinh luong cua nam thu n");

        int baseSalary = 1_000_000; // Luong co ban
        int year = 2; // So nam
        System.out.println("Tinh luong su dung De quy: " + calSalaryRecursion(baseSalary, year));
        System.out.println("Tinh luong k su dung De quy: " + calSalaryNonRecursion(baseSalary, year));
        System.out.println("\n");

        // 22. Calculate month 
        System.out.println("22. Tinh so thang can thiet de so tien x2");
        int money = 1_000_000; // So tien gui
        double rate = 0.035; // Lai suat
        System.out.println("Tinh so thang su dung De quy: " + calMonthRecursion(money, rate, money * 2, 0));
        System.out.println("Tinh so thang khong su dung De quy: " + calMonthNonRecursion(money, rate));
    }

///---------------------------------------------------------------------------------
    private static int calMonthNonRecursion(double money, double rate) {
        double moneyGet = money * 2;
        int count = 0;
        while (money < moneyGet) {
            money *= (1 + rate);
            count++;
        }
        return count;
    }

    private static int calMonthRecursion(double money, double rate, double moneyGet, int numMonth) {
        if (money >= moneyGet) {
            return numMonth;
        } else {
            return calMonthRecursion((rate + 1) * money, rate, moneyGet, numMonth + 1);
        }
    }

    private static double calSalaryRecursion(double baseSalary, int year) {
        if (year < 1) {
            return baseSalary;
        } else {
            return calSalaryRecursion(1.1 * baseSalary, year - 1);
        }
    }

    private static double calSalaryNonRecursion(double baseSalary, int year) {
        for (int i = 0; i < year; i++) {
            baseSalary *= 1.1;
        }
        return baseSalary;
    }

    private static void maxByPrice(List<Product> pList) {
        int max = Integer.MIN_VALUE;

        for (Product p : pList) {
            if (p.getPrice() >= max) {
                max = p.getPrice();
            }
        }

        System.out.println("Danh sach product co price max");
        for (Product p : pList) {
            if (p.getPrice() == max) {
                System.out.println(p.toString());
            }
        }

        System.out.println("\n");
    }

    private static void minByPrice(List<Product> pList) {
        int min = Integer.MAX_VALUE;

        for (Product p : pList) {
            if (p.getPrice() <= min) {
                min = p.getPrice();
            }
        }

        System.out.println("Danh sach product co price min");
        for (Product p : pList) {
            if (p.getPrice() == min) {
                System.out.println(p.toString());
            }
        }

        System.out.println("\n");
    }

    private static void mapProductByCate(List<Product> pList, List<Category> cList) {
        Map<Product, String> mapProduct = new HashMap<>();

        for (Product p : pList) {
            for (Category c : cList) {
                if (p.getCategoryID() == c.getId()) {
                    mapProduct.put(p, c.getName());
                    break;
                }
            }
        }

        System.out.println("Danh sach product + category:");
        for (Map.Entry<Product, String> entry : mapProduct.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println(key.toString() + " - " + val);
        }
        System.out.println("\n");
    }

    private static void sortByCateName(List<Product> pList, List<Category> cList) {
        Product[] arrProduct = new Product[pList.size()];
        Category[] arrCate = new Category[cList.size()];
        List<Product> pListNew = new ArrayList<>();

        for (int i = 0; i < arrProduct.length; i++) {
            arrProduct[i] = pList.get(i);
        }

        for (int i = 0; i < arrCate.length; i++) {
            arrCate[i] = cList.get(i);
        }

        System.out.println("Danh sach Product chua Insertion Sort:");
        for (int i = 0; i < arrProduct.length; i++) {
            System.out.println(arrProduct[i].toString());
        }
        System.out.println();

        System.out.println("Danh sach Category chua Insertion Sort:");
        for (int i = 0; i < arrCate.length; i++) {
            System.out.println(arrCate[i].toString());
        }
        System.out.println();

        int nCate = arrCate.length;
        for (int i = 1; i < nCate; ++i) {
            String key = arrCate[i].getName();
            Category keyProduct = arrCate[i];
            int j = i - 1;

            while (j >= 0 && arrCate[j].getName().compareTo(key) > 0) {
                arrCate[j + 1] = arrCate[j];
                j = j - 1;
            }
            arrCate[j + 1] = keyProduct;
        }

        int nProduct = arrProduct.length;
        for (int i = 0; i < nCate; i++) {
            for (int j = 0; j < nProduct; j++) {
                if (arrProduct[j].getCategoryID() == arrCate[i].getId()) {
                    pListNew.add(arrProduct[j]);
                }
            }
        }

        System.out.println("Danh sach Product da Insertion Sort:");
        for (Product product : pListNew) {
            System.out.println(product.toString());
        }
        System.out.println();

        System.out.println("Danh sach Category da Insertion Sort:");
        for (int i = 0; i < arrCate.length; i++) {
            System.out.println(arrCate[i].toString());
        }

        System.out.println("\n");
    }

    private static void sortByPrice(List<Product> pList) {
        Product[] arrProduct = new Product[pList.size()];

        for (int i = 0; i < arrProduct.length; i++) {
            arrProduct[i] = pList.get(i);
        }

        System.out.println("Danh sach chua bubble sort:");
        for (int i = 0; i < arrProduct.length; i++) {
            System.out.println(arrProduct[i].toString());
        }
        System.out.println();

        int n = arrProduct.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrProduct[j].getPrice() > arrProduct[j + 1].getPrice()) {
                    Product temp = arrProduct[j];
                    arrProduct[j] = arrProduct[j + 1];
                    arrProduct[j + 1] = temp;
                }
            }
        }

        System.out.println("Danh sach da bubble sort:");
        for (int i = 0; i < arrProduct.length; i++) {
            System.out.println(arrProduct[i].toString());
        }
        System.out.println("\n");
    }

    private static void sortByName(List<Product> pList) {
        Product[] arrProduct = new Product[pList.size()];

        for (int i = 0; i < arrProduct.length; i++) {
            arrProduct[i] = pList.get(i);
        }

        System.out.println("Danh sach chua Insertion Sort:");
        for (int i = 0; i < arrProduct.length; i++) {
            System.out.println(arrProduct[i].toString());
        }
        System.out.println();

        int n = arrProduct.length;
        for (int i = 1; i < n; ++i) {
            int key = arrProduct[i].getName().length();
            Product keyProduct = arrProduct[i];
            int j = i - 1;

            while (j >= 0 && arrProduct[j].getName().length() > key) {
                arrProduct[j + 1] = arrProduct[j];
                j = j - 1;
            }
            arrProduct[j + 1] = keyProduct;
        }

        System.out.println("Danh sach da Insertion Sort:");
        for (int i = 0; i < arrProduct.length; i++) {
            System.out.println(arrProduct[i].toString());
        }

        System.out.println("\n");
    }

    private static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    private static void selectionSort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    private static void insertArray(int[] A, int item, int insertPos) {
        int tmpPointer = A.length - 1;

        System.out.println("--- Danh sach phan tu trong mang");
        for (int i = 0; i < A.length; i++) {
            System.out.printf("A[%d] = %d \n", i, A[i]);
        }
        System.out.println();

        if (insertPos < A.length) {
            int[] newA = Arrays.copyOf(A, A.length + 1);

            while (tmpPointer >= insertPos - 1) {
                newA[tmpPointer + 1] = newA[tmpPointer];
                tmpPointer--;
            }

            newA[insertPos - 1] = item;

            System.out.println("--- Danh sach phan tu trong mang moi");
            for (int i = 0; i < newA.length; i++) {
                System.out.printf("newA[%d] = %d \n", i, newA[i]);
            }
            System.out.println();
        } else {
            System.out.println("Khong co vi tri tren trong mang!");
            System.out.println();

        }
    }

    private static void deleteArray(int[] A, int deletePos) {
        System.out.println("--- Danh sach phan tu trong mang");
        for (int i = 0; i < A.length; i++) {
            System.out.printf("A[%d] = %d \n", i, A[i]);
        }
        System.out.println();

        if (deletePos < A.length) {
            int[] newA = new int[A.length - 1];
            for (int i = 0; i < A.length - 1; i++) {
                if (i < deletePos - 1) {
                    newA[i] = A[i];
                } else {
                    newA[i] = A[i + 1];
                }
            }

            System.out.println("--- Danh sach phan tu trong mang moi");
            for (int i = 0; i < newA.length; i++) {
                System.out.printf("newA[%d] = %d \n", i, newA[i]);
            }
            System.out.println();
        } else {
            System.out.println("Khong co vi tri tren trong mang!");
            System.out.println();
        }
    }

    private static void searchArray(int[] A, int item) {
        int check = 0;

        System.out.println("--- Danh sach phan tu trong mang");
        for (int i = 0; i < A.length; i++) {
            System.out.printf("A[%d] = %d \n", i, A[i]);
        }
        System.out.println();

        for (int i = 0; i < A.length; i++) {
            if (A[i] == item) {
                System.out.printf("Tim thay phan tu %d tai vi tri %d \n", item, i);
                check++;
            }
        }
        if (check == 0) {
            System.out.println("Khong tim thay phan tu nao!");
        }
        System.out.println();
    }

    public static List<Product> findProduct(List<Product> pList, String pName) {
        List<Product> responseList = new ArrayList<>();
        for (Product p : pList) {
            if (p.getName().equals(pName)) {
                responseList.add(p);
            }
        }
        if (responseList.isEmpty()) {
            return null;
        } else {
            return responseList;
        }
    }

    public static List<Product> findProductByCategory(List<Product> pList, int cateID) {
        List<Product> responseList = new ArrayList<>();
        for (Product p : pList) {
            if (p.getCategoryID() == (cateID)) {
                responseList.add(p);
            }
        }
        if (responseList.isEmpty()) {
            return null;
        } else {
            return responseList;
        }
    }

    public static List<Product> findProductByPrice(List<Product> pList, int price) {
        List<Product> responseList = new ArrayList<>();
        for (Product p : pList) {
            if (p.getPrice() <= (price)) {
                responseList.add(p);
            }
        }
        if (responseList.isEmpty()) {
            return null;
        } else {
            return responseList;
        }
    }

    private static void importDataProduct() {
        pList = new ArrayList<Product>();
        pList.add(new Product("CPU", 750, 10, 1));
        pList.add(new Product("RAM", 50, 2, 2));
        pList.add(new Product("HDD", 70, 1, 2));
        pList.add(new Product("Main", 400, 3, 1));
        pList.add(new Product("Keyboard", 30, 8, 4));
        pList.add(new Product("Mouse", 25, 50, 4));
        pList.add(new Product("VGA", 60, 35, 3));
        pList.add(new Product("Monitor", 120, 28, 2));
        pList.add(new Product("Case", 120, 28, 5));
    }

    private static void importDataCategory() {
        cList = new ArrayList<Category>();
        cList.add(new Category(1, "Comuter"));
        cList.add(new Category(2, "Memory"));
        cList.add(new Category(3, "Card"));
        cList.add(new Category(4, "Acssesory"));
    }

    private static void showResult(List<Product> pResponseList, int type) {

        switch (type) {
            case 1:
                if (pResponseList != null) {
                    System.out.println("--- Ket qua:");
                    for (Product product : pResponseList) {
                        System.out.println(product.toString());
                    }
                    System.out.println();
                } else {
                    System.out.println("--- Khong co san pham nao co ten nhu the!\n");
                }
                break;
            case 2:
                if (pResponseList != null) {
                    System.out.println("--- Ket qua:");
                    for (Product product : pResponseList) {
                        System.out.println(product.toString());
                    }
                    System.out.println();

                } else {
                    System.out.println("--- Khong co san pham nao co Cate ID nhu the!\n");
                }
                break;
            case 3:
                if (pResponseList != null) {
                    System.out.println("--- Ket qua:");
                    for (Product product : pResponseList) {
                        System.out.println(product.toString());
                    }
                    System.out.println();

                } else {
                    System.out.println("--- Khong co san pham nao co Price nhu the!\n");
                }
                break;
            default:
                throw new AssertionError();
        }
    }

}
