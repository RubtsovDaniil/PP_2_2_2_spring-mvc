package web.service;

import org.springframework.stereotype.Component;
import web.dao.CarDao;
import web.dao.CarDaoImpl;
import web.model.Car;

import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    CarDao userDao = new CarDaoImpl();

    @Override
    public List<Car> show(Integer count) {
        return userDao.show(count);
    }
}
