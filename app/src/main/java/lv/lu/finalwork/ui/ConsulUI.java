package lv.lu.finalwork.ui;

import lv.lu.finalwork.model.repository.ProductCategory;
import lv.lu.finalwork.model.ui.ProductInputData;
import lv.lu.finalwork.service.ProductService;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsulUI {

    private ProductService service;
    private final Scanner scanner = new Scanner(System.in);

    public void ConsulUi () {
        this.service = new ProductService();
    }

    public void startUi() {

        int userChoice;
        while (true) {
            printMenu();
            userChoice = scanner.nextInt();

            callServiceByChoice(userChoice);

            if (userChoice == 0) {
                break;
            }
        }
    }

    private void callServiceByChoice(int userChoice) {
        switch (userChoice) {
            case 1:
                initProductSave();
                break;
        }
    }

    private void initProductSave() {
        ProductInputData productInputData = new ProductInputData();
        System.out.println("Enter product name.. ");
        productInputData.setName(scanner.next());
        System.out.println("Enter product price.. ");
        productInputData.setPrice(BigDecimal.valueOf(scanner.nextDouble()));
        System.out.printf("Enter product category from (%s)", ProductCategory.values());
        productInputData.setCategory(ProductCategory.valueOf(scanner.next()));
        service.save(productInputData);
    }

    private void printMenu() {
        System.out.println(" === Product Accounting application === ");
        System.out.println(" Chose one option: \n");
        System.out.println(" Save product: - 1");
        System.out.println(" Exit application: - 0");
        System.out.println(" Please enter the choice");
    }
}
