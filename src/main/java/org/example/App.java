package org.example;

public class App
{
    public static void main(String[] args) {
        CarDao carDao = new CarDao();
        carDao.createCarsTable(); // Создали таблицу и поля
        carDao.addCar(1, "ВАЗ", "2115", "А115АУ77", "2003");
        carDao.addCar(2, "ГАЗ", "3102", "В525АЕ18", "1999");
        carDao.addCar(3, "МАЗ", "5515", "Р458ОО89", "1997");
        carDao.addCar(4, "УАЗ", "2915", "А118АУ08", "2003");
        carDao.addCar(5, "ЗИЛ", "4331", "А812АА05", "2015");

//        System.out.println(carDao.getAllCars()); // Получили список авто
//        carDao.deleteCar(2); // Удалили поле по id
//        System.out.println(carDao.getAllCars()); // Получили список авто после удаления поля

//        System.out.println("Нашли авто по id " + carDao.getCarsById(3));
        carDao.cleanCarTable();

//        carDao.dropCarsTable(); // Удалил таблицу

    }
}
