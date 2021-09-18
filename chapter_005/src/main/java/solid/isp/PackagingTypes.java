package solid.isp;

public interface PackagingTypes {
    void ppackage();
    void cannedFood();
    void bottle();
    /*
    если для какого то продукта метода упаковки не существует, скажем для собачего корма нет бутылок, то все
    равно его придется реализовывать - это ошибка ISP
     */
}
