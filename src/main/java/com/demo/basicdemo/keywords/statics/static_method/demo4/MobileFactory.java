package com.demo.basicdemo.keywords.statics.static_method.demo4;

/**
 * 工厂类的生产方法通常设计为静态方法
 */
public class MobileFactory {

    /**
     * 面向接口调用
     *
     * @param brand
     * @return
     */
    public static CellPhone getCellPhone(String brand) {
        if (brand.equalsIgnoreCase("Apple")) {
            return new Apple(brand);
        }

        if (brand.equalsIgnoreCase("Huawei")) {
            return new Huawei(brand);
        }

        return null;
    }

    public static void main(String[] args) {
        CellPhone apple = MobileFactory.getCellPhone("Apple");
        CellPhone huawei = MobileFactory.getCellPhone("Huawei");
        apple.showBrand();
        huawei.showBrand();
    }
}


interface CellPhone {
    void showBrand();
}

/**
 * 面向接口实现
 */
class Apple implements CellPhone {

    private String brand;

    public Apple(String brand) {
        this.brand = brand;
    }

    @Override
    public void showBrand() {
        System.out.println("I am " + brand);
    }
}


/**
 * 面向接口实现
 */
class Huawei implements CellPhone {

    private String brand;

    public Huawei(String brand) {
        this.brand = brand;
    }

    @Override
    public void showBrand() {
        System.out.println("I am " + brand);
    }
}