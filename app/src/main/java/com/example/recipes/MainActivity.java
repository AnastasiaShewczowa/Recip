package com.example.recipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recipes.adapter.CategoryAdapter;
import com.example.recipes.adapter.DiscountedProductAdapter;
import com.example.recipes.adapter.FoodAdapter;
import com.example.recipes.model.Category;
import com.example.recipes.model.DiscountedProducts;
import com.example.recipes.model.FoodItem;
import com.example.recipes.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    RecyclerView discountRecyclerView, categoryRecyclerView, recyclerItems;
    DiscountedProductAdapter discountedProductsAdapter;
    List<DiscountedProducts> discountedProductsList;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;


    static FoodAdapter foodAdapter;
    static List<FoodItem> foodItemList = new ArrayList<>();
    static List<FoodItem> fullfoodItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils.changeStatusBarAndNavigationBarColor(MainActivity.this, R.color.mirage, R.color.mirage_dark);


        discountRecyclerView = findViewById(R.id.discountedRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        recyclerItems = findViewById(R.id.foodrecycler);


        EditText editText = findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());

            }
        });

        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts("Арбуз", R.drawable.arbuz));
        discountedProductsList.add(new DiscountedProducts("Банан", R.drawable.banan));
        discountedProductsList.add(new DiscountedProducts("Бекон", R.drawable.bekon));
        discountedProductsList.add(new DiscountedProducts("Клубника", R.drawable.klubnika));
        discountedProductsList.add(new DiscountedProducts("Креветка", R.drawable.krevetka));
        discountedProductsList.add(new DiscountedProducts("Мясо", R.drawable.myaso_2));
        discountedProductsList.add(new DiscountedProducts("Пицца", R.drawable.picha));
        discountedProductsList.add(new DiscountedProducts("Сыр", R.drawable.sir));
        discountedProductsList.add(new DiscountedProducts("Торт", R.drawable.tort));
        discountedProductsList.add(new DiscountedProducts("Яблоко", R.drawable.yabloco));

        categoryList = new ArrayList<>();
       // categoryList.add(new Category(0,"Все меню", R.drawable.ic_menu_book_food_drink_icon_146855));
        categoryList.add(new Category(1,"Сладости", R.drawable.ic_sladosti));
        categoryList.add(new Category(2,"Яйцо", R.drawable.ic_cho));
        categoryList.add(new Category(3,"Мясо", R.drawable.ic_myaso_myaso));
        categoryList.add(new Category(4,"Раба", R.drawable.ic_fish));
        categoryList.add(new Category(5,"Мучное", R.drawable.ic_baguette));
        categoryList.add(new Category(6,"Прочее", R.drawable.ic__053442));


        foodItemList.add(new FoodItem(1,"Чизкейк нью йорк", "1 порции: 182 кКал","Время приготовления: 20 минут", "Печенье песочное - 300 г \nМасло сливочное - 100 г \nСыр сливочный - 600 г \nСахар - 150 г \nЯйца - 3 шт \nСливки 30-35% - 200 мл", "1. Печенье измельчите в мелкую крошку с помощью стационарного блендера, либо раздробите его скалкой, предварительно заворачивая небольшие порции печенья в пакет.\n" +

                    "2. Сливочное масло растопите в микроволновой печи или на водяной бане. Смешайте его с печеньем до состояния влажной крошки.\n" +

                    "3. Дно формы для запекания смажьте растительным маслом. Застелите ровным кругом пергамента, чтоб он прилип ко дну.\n" +
                    "Тесто высыпьте в форму и утрамбуйте руками или с помощью стакана с ровным дном. Выпекайте основу 10 минут до ровного золотистого цвета. Затем полностью остудите, чтобы при заливании начинки не образовалось конденсата.\n" +
                    "\n" + "Мы использовали разъёмную форму диаметром 26 сантиметров.\n" +
                    "\n" + "После выпекания коржа убавьте температуру в духовке до 160 °С.\n" +

                    "4. Пока остывает основа, приготовьте сырную начинку.\n" +
                    "\n" +
                    "Сахар измельчите в пудру с помощью блендера или кофемолки. Можно купить готовую сахарную пудру, в составе которой нет крахмала.\n" +
                    "\n" +
                    "К сахарной пудре добавьте сыр. Тщательно перемешайте лопаткой до однородной консистенции. Не взбивайте, иначе чизкейк получится с трещинами.\n" +

                    "5. Введите яйца по одному, после каждого перемешивайте массу лопаткой до однородной консистенции.\n" +
                    "\n" +
                    "Влейте сливки и снова перемешайте лопаткой.\n" +

                    "6.Вылейте сырную массу на остывший корж и разровняйте лопаткой. Дно и бока формы для выпечки снаружи обмотайте фольгой, чтобы вода не проникла внутрь чизкейка. Поставьте форму в глубокий противень и налейте в него столько воды, чтобы она доходила до середины формы.\n" +
                    "\n" +
                    "Выпекайте 50-60 минут до слегка заметного кремового цвета поверхности. Затем приоткройте дверцу духовки и выпекайте чизкейк ещё 40-60 минут.\n" +
                    "\n" +
                    "Достаньте чизкейк из духовки, остудите до комнатной температуры, не вынимая из формы. Затем обмотайте его пищевой плёнкой и поставьте в холодильник на 3-4 часа, а лучше на ночь.", R.drawable.sladosti_1, R.drawable.sladosti_1,1));


            foodItemList.add(new FoodItem(2,"Мороженное", "1 порции: 82 кКал","Время приготовления: 20 минут","Сливки жирностью от 33-35% - 600-700 г \nСгущенное молоко - 200-250 г", "1. Взбить охлаждённые жирные сливки с помощью миксера (долго не взбивать, только до густоты).\n" +
                    "\n" +
                    "2. Добавить сгущенное молоко - от 1/2 до 2/3 банки, по своему вкусу. Перемешать (можно миксером, но недолго).\n" +
                    "\n" +
                    "3. Выложить массу в подходящую посуду и поместить в морозильник. Замораживать 3-6 часов (можно оставить до следующего дня). Время замораживания зависит от объема посуды и температуры в морозильной камере.\n" +
                    "\n" +
                    "4. Перед подачей домашнее мороженое лучше подержать немного в холодильнике, чтобы оно стало чуть мягче. Подавать пломбир можно, например, посыпав тертым шоколадом.\n" + "\n" +

                    "Примечание: Можно сделать ванильный или шоколадный домашний пломбир, добавив по вкусу ваниль или какао-порошок.", R.drawable.sladosti_2, R.drawable.sladosti_2, 1));

            foodItemList.add(new FoodItem(3,"Карамель", "1 порции: 382 кКал","Время приготовления: 6 часов","Сахар – 150 г \nВода – 50 мл \nУксус – 1 ч. ложка \nРастительное масло для смазывания форм", "С помощью кисточки тщательно промажьте форму растительным маслом, соберите форму для карамели по инструкции. В кастрюлю засыпьте сахар, залейте водой и нагревайте, помешивая, пока весь сахар не расплавится. Как только сахар расплавился, убавьте огонь и варите сироп до 155-160 градусов. Карамель должна стать светло-желтого цвета. Разлейте карамель по формочкам (осторожно, карамель очень горячая!), вставьте палочки и оставьте до застывания. Если карамель плохо выходит из металлической формы, можно слегка нагреть форму на плите. При желании часть воды в рецепте можно заменить фруктовым соком или сиропом из варенья.", R.drawable.sladosti_3, R.drawable.sladosti_3, 1));

            foodItemList.add(new FoodItem(4,"Омлет с лисичками", "1 порции: 160 кКал","Время приготовления: 20 минут", "Лисички  — 100 Грамм \nЯйца  — 2 Штуки \nЛуковица  — 1 Штука \nСметана  — 2 Ст. ложки \nСоль  — 1 Щепотка \nПерец  — 1 Щепотка \nРастительное масло  — 1-2 Ст. ложек ", "1. Набор необходимых продуктов довольно скромен, а рецепт приготовления омлета с лисичками настолько прост, что с ним справится даже новичок на кухне. Яйца можно взбить не только со сметаной, но и с молоком, например. Если под рукой не оказалось ни того, ни другого, вполне можно обойтись и без них. \n" +

                    "2. Для начала следует заняться грибами. Лисички тщательно промыть, очистить и при желании измельчить. \n" +

                    "3. Луковицу очистить и нарезать небольшими кубиками или тонкими полукольцами. \n" +

                    "4. На сковороду налить немного растительного (можно заменить сливочным при желании) масла и отправить туда лук. Обжарить на среднем огне до прозрачности. \n" +

                    "5. Затем добавить к луку грибочки и жарить, периодически помешивая, до готовности. В среднем этот процесс займет не более 10 минут. Можно слегка посолить и поперчить лисички. \n" +

                    "6. Яйца вбить в мисочку и добавить немного сметаны. Венчиком или вилкой взбить до однородной массы. Добавить щепотку соли и при желании любимые специи. \n" +

                    "7. Омлет можно жарить на отдельной сковороде или той, в которой ", R.drawable.chicken_1, R.drawable.chicken_1, 2));

            foodItemList.add(new FoodItem(5,"Варенные яйца", "1 порции: 60 кКал","Время приготовления: 20 минут", "Яйцо - 2 шт","Яйца комнатной температуры надо аккуратно, чтобы не разбить, положить в сотейник с водой и залить их водой так, чтобы она полностью покрывала яйца. Довести воду до кипения, уменьшить огонь и варить при пузырьковом кипении 7 минут — это идеальное время для варки вкрутую. Для яиц в мешочек разброс шире — от 5 до 6 минут. Совершенные яйца всмятку готовят 4 минуты после закипания воды.", R.drawable.chicken_2, R.drawable.chicken_2, 2));
            foodItemList.add(new FoodItem(6,"Яйца с томатами", "1 порции: 110 кКал","Время приготовления: 6 часов", "Яйца - 3 шт.\n" +
                    "Перец болгарский красный - 1 шт. (250 г)\n" +
                    "Перец болгарский жёлтый - 1 шт. (250 г)\n" +
                    "Перец болгарский зелёный - 1 шт. (250 г)\n" +
                    "Помидор - 120 г (1 шт.)\n" +
                    "Соль - щепотка\n" +
                    "Перец чёрный молотый - щепотка\n" +
                    "Масло растительное (для жарки) - 2 ст. ложки\n" +
                    "Укроп свежий (для подачи) - 1 веточка\n","1. Болгарские перцы тщательно вымойте. С каждого перца срежьте \"крышку\" с плодоножкой, удалите семена и хвостик. Нарежьте каждый перец кольцами толщиной примерно 1-1,5 см.\n" +

                    "2. Я использовала только по одному, самому широкому по диаметру кольцу из перца каждого цвета. (Из остатков перца можно приготовить салат или лечо, или съесть просто так - это и полезно, и вкусно!)\n" +

                    "3. В сковороде на среднем огне разогрейте растительное масло. Выложите колечки перца в сковороду и жарьте примерно 1-2 минуты.\n" +

                    "4. Помидор вымойте и нарежьте кружочками толщиной примерно полсантиметра. Переверните колечки перца на другую сторону и поместите внутрь каждого по кружочку помидора.\n" +

                    "5. Аккуратно вбейте в каждое колечко перца по одному яйцу. Слегка посолите яйца.\n" +

                    "6. Жарьте яичницу в перце на среднем огне примерно 4-5 минут. Крышкой накрывать не стоит, чтобы глазуньи получились с яркими желтками.\n" +

                    "7. Яркая яичница в перце с помидорами готова. \n" +

                    "8. Лопаткой аккуратно снимите их на тарелку, присыпьте чёрным молотым перцем и подавайте к столу, по желанию украсив свежей зеленью.\n" +

                    "9. Такая простая и в то же время гениальная идея - использовать колечки перца как формочки для яичницы. Отличный способ приготовить яичницу необычно!\n" +

                    "10. Сочный сладкий перец, мягкий помидор и вкусная яичница - отличный завтрак, ведь это недорого, полезно, ароматно и питательно.\n" +

                    "11. Такой яркий завтрак-\"светофор\" очень нравится детям. Обязательно приготовьте им яркий завтрак перед школой, и их настроение улучшится.\n" +

                    "12. Приятного аппетита!", R.drawable.chicken_3, R.drawable.chicken_3, 2));


            foodItemList.add(new FoodItem(7,"Азу по-татарски с тушенкой (в мультиварке)", "1 порции: 250 кКал","Время приготовления: 20 минут","Тушенка из говядины - 1 банка\n" +
                    "Картофель - 8 шт.\n" +
                    "Морковь - 2 шт.\n" +
                    "Лук репчатый - 2 шт.\n" +
                    "Чеснок - 5 зуб.\n" +
                    "Огурцы соленые - 3 шт.\n" +
                    "Томатная паста - 30 грамм\n" +
                    "Масло оливковое\n" +
                    "Лавровый лист - 3-4 шт.\n" +
                    "Перец молотый\n" +
                    "Соль", "1. Очищенные луковицы нарежьте кусочками среднего размера.\n" +

                    "2. Налейте в чашу мультиварки оливковое масло, выложите порезанный лук и включите программу «Жарка».\n" +

                    "3. Пока лук будет обжариваться, нарубите кубиками очищенную морковь.\n" +

                    "4. Затем выложите ее в мультиварку, помешайте и жарьте овощи еще около 10 минут.\n" +

                    "5. Почистите картофель и нарежьте его брусочками.\n" +

                    "6. Положите кусочки картофеля к обжаренным луку и моркови.\n" +

                    "7. Перемешайте овощи и продолжайте готовить их в режиме «Жарка» в течение 15 минут.\n" +

                    "8. Соленые огурцы порежьте кубиками примерно такого же размера, что и морковь.\n" +

                    "9. Очищенные дольки чеснока нарежьте в виде тонких пластинок.\n" +

                    "10. Бросьте чеснок в мультиварку к обжаренному картофелю.\n" +

                    "11. Затем добавьте томатную пасту (по желанию ее можно заменить мелко нарезанными свежими помидорами).\n" +

                    "12. Влейте в мультиварку 150 мл воды, поперчите и посолите продукты, а после тщательно перемешайте.\n" +

                    "13. Закройте крышку и включите режим «Тушение» на 30 минут. \n" +

                    "14. В середине программы откройте мультиварку и выложите в нее порезанные соленые огурцы, перемешайте содержимое чаши и закройте крышку.\n" +

                    "15. Еще через 10 минут положите в мультиварку говяжью тушенку и добавьте 2-3 лавровых листа.\n" +

                    "16. Снова перемешайте продукты, при необходимости подсолите, а затем закройте крышку прибора и дождитесь окончания программы.\n" +

                    "17. Перед подачей посыпьте азу по-татарски с тушенкой свежей зеленью. Приятного аппетита!", R.drawable.myaso_1, R.drawable.myaso_1, 3));
            foodItemList.add(new FoodItem(8,"Мясной рулет с грибами и сыром", "1 порции: 560 кКал","Время приготовления: 2 часа", "Свинина (корейка без кости или шея) - 1,2 кг\n" +
                    "Грибы (шампиньоны, лисички или другие) - 250 г\n" +
                    "Сыр твердый - 100 г\n" +
                    "Лук репчатый - 100 г\n" +
                    "Чеснок (по желанию) - 1 зубок\n" +
                    "Зелень укропа или петрушки - по вкусу\n" +
                    "Соль - по вкусу\n" +
                    "Перец черный молотый - по вкусу\n" +
                    "Масло растительное - 50 мл","1. Подготовьте все продукты для мясного рулета из свинины с грибами и сыром.\n" +

                    "2. Мясо промойте, обсушите бумажным полотенцем. Вдоль всего куска свинины сделайте глубокий надрез и разверните кусок, как книгу, в тонкий пласт.\n" +

                    "3. Накройте мясо пищевой пленкой или полиэтиленовым пакетом и хорошо отбейте кухонным молотком, чтобы мясо было не больше 2 см толщиной. Отбитый пласт мяса посыпьте солью и перцем.\n" +

                    "4. Теперь приготовьте начинку. Для этого лук, нарезанный мелкими кубиками, обжарьте до прозрачности на сковороде с разогретым растительным маслом.\n" +
                    "Грибы, нарезанные пластинами, добавьте к луку.\n" +

                    "5. Жарьте грибы до готовности.\n" +

                    "6. К немного остывшим грибам с луком добавьте мелко нарезанную зелень и сыр, натертый на крупной терке. Соль и перец добавьте по вкусу.\n" +

                    "7. Чеснок мелко порубите и добавьте в сырно-грибную начинку (по желанию).\n" +

                    "8. Выложите приготовленную начинку на мясо с короткой стороны.\n" +

                    "9. Сверните мясо с грибами и сыром в аккуратный рулет, следя за тем, чтобы начинка оказалась внутри и была полностью, со всех сторон, покрыта мясом.\n" +

                    "10. Рулет из свинины с грибами и сыром перевяжите кулинарной ниткой или скрепите края деревянными зубочистками.\n" +

                    "11. В сковороде хорошо разогрейте масло, обжарьте мясной рулет со всех сторон на сильном огне, до румяности.\n" +

                    "12. Обжаренный мясной рулет запекайте в духовке, разогретой до 180 градусов, на протяжении 1,5 часа. Когда мясо хорошо подрумянится, накройте рулет фольгой и запекайте до полной готовности.\n" +

                    "13. Готовый мясной рулет с грибной начинкой достаньте из духовки и дайте мясу \"отдохнуть\" около 15 минут.\n" +

                    "14. Мясной рулет с грибами и сыром нарежьте ломтиками, подавайте в горячем или холодном виде. Приятного аппетита!", R.drawable.myaso_2, R.drawable.myaso_2, 3));

            foodItemList.add(new FoodItem(9,"Котлета из свинины", "8 порций: 480 кКал","Время приготовления: 6 часов", "Фарш свиной – 1 кг\n" +
                    "Лук репчатый – 2 шт.\n" +
                    "Яйца – 2 шт.\n" +
                    "Булка белая – 2 ломтика\n" +
                    "Молоко – 0,5 стакана\n" +
                    "Соль – по вкусу\n" +
                    "Перец – по вкусу\n" +
                    "Панировочные сухари – сколько уйдет\n" +
                    "Масло растительное – 3 ст. ложки\n","1. Репчатый лук очистить, промыть и натереть на мелкой тёрке.\n" +

                    "2. Хлеб замочить в молоке. Затем хлеб размять.\n" +

                    "3. В свиной фарш добавить лук, хлеб, яйца, соль и перец. Всё хорошо перемешать.\n" +

                    "4. Сформировать из фарша котлеты, обвалять их в панировочных сухарях.\n" +

                    "5. Разогреть сковороду, налить растительное масло. Обжарить котлеты на среднем огне до образования румяной корочки (4-5 минут) с одной стороны, а затем с другой.", R.drawable.myaso_3, R.drawable.myaso_3,3));

        foodItemList.add(new FoodItem(10,"Рыбка под маринадом", "8 порций: 480 кКал","Время приготовления: 6 часов", "Любая рыбка (пикша, минтай, путасу, хек, кефаль, треска),(у меня рыбка треска примерно грамм 600 была)\n" +
                "Для маринада:\n" +
                "Морковь - 3-4 шт.\n" +
                "Луковица - 2 шт.\n" +
                "Томатная паста - 1 ст. л. (или кетчупа), (кетчупа даже лучше добавить, так как тогда маринад получается остреньким, насыщенным вкусом) ","1. Рыбку отварить, отделить от костей и мелко порезать.\n" +

"2. Сделать обжарку (типа маринад). Обжарить лук, морковь добавить томат пасту (у меня кетчуп острый с чесноком) обжарили потом добавить примерно стакан воды и потушить на медленном огне до готовности морковки, следите за тем чтобы маринад не был сухим.\n" +

"3. Выкладываем слоями, слой рыбы, сверху слой обжарки, и так далее. Последний слой должен быть обжарки.\n", R.drawable.fush, R.drawable.fush,4));


        foodItemList.add(new FoodItem(11,"Коктейль для иммунитета", "8 порций: 480 кКал","Время приготовления: 2 часа 30 минут", "Лимоны - 2 шт.\n" +
                "Имбирь свежий - 5 см корешка\n" +
                "Гранат - 1/2 шт.\n" +
                "Сахар - 2 ст.ложки\n" +
                "Мята свежая - 1 жменька\n" +
                "Корица (по желанию)\n" +
                "Гвоздика (по желанию)","1. Лимоны хорошо моем и рубим на кусочки.\n" +
                "2. Отправляем в кастрюлю с 2-мя литрами воды. Доводим до кипения и уменьшаем до среднего огня. Добавляем сахар.\n" +
                "Имбирь чистим и мелко режем. Отделяем зернышки граната.\n" +
                "Имбирь и гранат насыпаем в варево после сахара. Потом добавляем мяту.\n" +
                "Вариться будет не меньше двух часов. Мята совсем станет непрезентабельной и ее нужно выловить.\n" +
                "Вкус должен быть весьма насыщенный. Важный момент: лимонная корочка должна стать мягкой - очень хорошо провариться.\n" +
                "Очень хорошо в холодное время года пить горячим - от простуды и для повышения иммунитета. Можно 1:1 мешать со спрайтом и получается очень вкусный напиток. Можно 1:1 мешать с холодной водой и получится неплохой компот:)", R.drawable.koktel, R.drawable.koktel,6));

        foodItemList.add(new FoodItem(12,"Морковь по-корейски", "1 порция: 290,16 кКал","Время приготовления: 20 минут", "Морковь\t1 кг = 1000 г\n" +
                "Репчатый лук\t1 шт. = 80 г\n" +
                "Чеснок\t2 зубчик = 4 г\n" +
                "Сладкая паприка\t1 ч. л. = 6 г\n" +
                "Молотый кориандр\t1 ч. л. = 2 г\n" +
                "Подсолнечное масло рафинированное\t5 ст. л. = 85 г\n" +
                "Сахар\t1 ст. л. = 25 г\n" +
                "Столовый уксус 6%\t5 ст. л. = 75 г\n" +
                "Соль\t1.5 ч. л. = 15 г\n","1. Тщательно вымыть овощи и очистить от кожуры. Приготовить чистую посуду для приготовления салата и емкость с крышкой для настаивания салата в холодильнике.\n" +
                "2. Натрите морковь длинной тонкой соломкой. Для этого подойдет специальная терка для моркови по-корейски. Добавьте соль и тщательно перемешайте руками около 2 минут, чтобы морковь начала выделять свой сок. Затем дайте натертой моркови постоять еще 15-20 минут\n" +
                "3. Чеснок пропустите через специальный пресс или нарубите мелко ножом. Отожмите руками морковь от излишней жидкости. Добавьте сахар, молотые семена кориандра, паприку и рубленный чеснок, тщательно перемешайте деревянной лопаткой.\n" +
                "4. Мелко нарежьте лук и бросьте его в хорошо разогретую сковороду с растительным маслом. Поджаривайте лук до золотистого цвета, затем шумовкой удалите лук и залейте морковь горячим маслом. Тщательно перемешайте, добавьте уксус и переложите морковь в чистую банку плотно. Накройте крышкой и уберите не несколько часов в холодильник.\n" +
                "5. Подавайте морковь по-корейски к обеду или ужину в дополнение к мясным блюдам.", R.drawable.morkov, R.drawable.morkov,6));


    //    foodItemList.add(new FoodItem("Наименование рецепта", "8 порций: 480 кКал","Время приготовления: 6 часов", " ","", R.drawable.fush, R.drawable.fush,4));


        fullfoodItemList.addAll(foodItemList);

        setRecyclerItems(foodItemList);
        setCategoryRecyclerView(categoryList);
        setDiscountRecycler(discountedProductsList);

    }

    public void izbran1(View view){
        Intent intent1 = new Intent(this,OrderIzbran.class);
        startActivity(intent1);
    }




    private static void filter(String text) {
        ArrayList<FoodItem> filteredList = new ArrayList<>();

        foodItemList.clear();
        foodItemList.addAll(fullfoodItemList);

        for (FoodItem item: foodItemList){
            if (item.getName().toLowerCase().contains(text.toLowerCase(Locale.ROOT))){
            filteredList.add(item);
        }
        }
        foodItemList.clear();
        foodItemList.addAll(filteredList);

        foodAdapter.notifyDataSetChanged();
        //foodAdapter.filteredList(filteredList);

    }


    private void setDiscountRecycler(List<DiscountedProducts> dataList){

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountedProductsAdapter = new DiscountedProductAdapter(this, dataList);
        discountRecyclerView.setAdapter(discountedProductsAdapter);

    }

    private void setCategoryRecyclerView(List<Category> categoryDataList){

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this, categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);

    }

    private void setRecyclerItems(List<FoodItem> foodDataItemList){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerItems.setLayoutManager(layoutManager);
        foodAdapter = new FoodAdapter(this, foodDataItemList);
        recyclerItems.setAdapter(foodAdapter);
    }

    public static void showCoursesByCategory(int category){

        foodItemList.clear();
        foodItemList.addAll(fullfoodItemList);

        List<FoodItem> filterCourses = new ArrayList<>();

        for(FoodItem c: foodItemList) {
            if (c.getCategory() == category)
                filterCourses.add(c);
        }

        foodItemList.clear();
        foodItemList.addAll(filterCourses);

        foodAdapter.notifyDataSetChanged();

    }

}