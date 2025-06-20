import {
  HeartIcon,
  HomeIcon,
  SearchIcon,
  ShoppingBagIcon,
  UserIcon,
} from "lucide-react";
import React from "react";
import { Card, CardContent } from "../../components/ui/card";
import { Input } from "../../components/ui/input";
import { Tabs, TabsList, TabsTrigger } from "../../components/ui/tabs";

// Watch category data for mapping
const watchCategories = [
  {
    id: 1,
    name: "Роскошные часы",
    image: "..//depth-5--frame-0.png",
  },
  {
    id: 2,
    name: "Спортивные часы",
    image: "..//depth-5--frame-0-1.png",
  },
  {
    id: 3,
    name: "Умные часы",
    image: "..//depth-5--frame-0-2.png",
  },
  {
    id: 4,
    name: "Классические часы",
    image: "..//depth-5--frame-0-3.png",
  },
];

// Tab data for mapping
const tabItems = [
  { id: 1, label: "Новинки", active: true },
  { id: 2, label: "Мужчины", active: false },
  { id: 3, label: "Женские", active: false },
  { id: 4, label: "Распродажа", active: false },
];

export const Screen = (): JSX.Element => {
  return (
    <div className="flex flex-col items-start relative bg-white">
      <div className="flex flex-col min-h-[844px] items-start justify-between relative self-stretch w-full flex-[0_0_auto] bg-[#f9f9f9]">
        <div className="flex flex-col items-start relative self-stretch w-full flex-[0_0_auto]">
          {/* Header */}
          <header className="items-center justify-between pt-4 pb-2 px-4 bg-[#f9f9f9] flex relative self-stretch w-full flex-[0_0_auto]">
            <div className="h-[23px] pl-12 pr-0 py-0 flex flex-col items-center relative flex-1 grow">
              <h1 className="relative self-stretch mt-[-1.00px] [font-family:'Plus_Jakarta_Sans',Helvetica] font-bold text-[#141414] text-lg text-center tracking-[0] leading-[23px]">
                Магазин часов
              </h1>
            </div>

            <div className="flex w-12 items-center justify-end relative">
              <button className="inline-flex h-12 items-center justify-center relative flex-[0_0_auto] rounded-3xl overflow-hidden">
                <ShoppingBagIcon className="h-6 w-6 text-[#141414]" />
              </button>
            </div>
          </header>

          {/* Search bar */}
          <div className="flex-col items-start px-4 py-3 flex relative self-stretch w-full flex-[0_0_auto]">
            <div className="flex-col min-w-40 h-12 items-start self-stretch w-full flex relative">
              <div className="flex items-start relative flex-1 self-stretch w-full grow rounded-xl">
                <div className="inline-flex items-center justify-center pl-4 pr-0 py-0 relative self-stretch flex-[0_0_auto] bg-[#ededed] rounded-[12px_0px_0px_12px]">
                  <SearchIcon className="h-6 w-6 text-[#727272]" />
                </div>

                <Input
                  className="flex items-center pl-2 pr-4 py-2 relative flex-1 self-stretch grow bg-[#ededed] rounded-[0px_12px_12px_0px] border-0 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-[#727272] [font-family:'Plus_Jakarta_Sans',Helvetica]"
                  placeholder="Поиск"
                />
              </div>
            </div>
          </div>

          {/* Category tabs */}
          <nav className="flex-col items-start pt-0 pb-3 px-0 flex relative self-stretch w-full flex-[0_0_auto]">
            <Tabs defaultValue="Новинки" className="w-full">
              <TabsList className="items-start gap-8 px-4 py-0 self-stretch w-full flex-[0_0_auto] border-b [border-bottom-style:solid] border-[#dbdbdb] flex relative bg-transparent h-auto">
                {tabItems.map((tab) => (
                  <TabsTrigger
                    key={tab.id}
                    value={tab.label}
                    className={`inline-flex flex-col items-center justify-center pt-4 pb-[13px] px-0 relative flex-[0_0_auto] border-b-[3px] [border-bottom-style:solid] border-[#e5e8ea] rounded-none data-[state=active]:border-[#141414] data-[state=active]:shadow-none ${tab.active ? "text-[#141414]" : "text-[#727272]"}`}
                  >
                    <span className="self-stretch mt-[-1.00px] font-bold text-sm leading-[21px] whitespace-nowrap relative [font-family:'Plus_Jakarta_Sans',Helvetica] tracking-[0]">
                      {tab.label}
                    </span>
                  </TabsTrigger>
                ))}
              </TabsList>
            </Tabs>
          </nav>

          {/* Watch categories grid */}
          <div className="flex-col items-start gap-3 p-4 flex relative self-stretch w-full flex-[0_0_auto]">
            <div className="grid grid-cols-2 gap-3 w-full">
              {watchCategories.slice(0, 2).map((category) => (
                <Card
                  key={category.id}
                  className="border-none bg-transparent shadow-none"
                >
                  <CardContent className="flex flex-col w-full items-start gap-3 pt-0 pb-3 px-0 p-0">
                    <div
                      className="relative self-stretch w-full h-[173px] rounded-xl"
                      style={{
                        background: `url(${category.image}) 50% 50% / cover`,
                      }}
                    />
                    <h3 className="self-stretch mt-[-1.00px] font-medium text-[#141414] text-base leading-6 relative [font-family:'Plus_Jakarta_Sans',Helvetica] tracking-[0]">
                      {category.name}
                    </h3>
                  </CardContent>
                </Card>
              ))}
            </div>

            <div className="grid grid-cols-2 gap-3 w-full">
              {watchCategories.slice(2, 4).map((category) => (
                <Card
                  key={category.id}
                  className="border-none bg-transparent shadow-none"
                >
                  <CardContent className="flex flex-col w-full items-start gap-3 pt-0 pb-3 px-0 p-0">
                    <div
                      className="relative self-stretch w-full h-[173px] rounded-xl"
                      style={{
                        background: `url(${category.image}) 50% 50% / cover`,
                      }}
                    />
                    <h3 className="self-stretch mt-[-1.00px] font-medium text-[#141414] text-base leading-6 relative [font-family:'Plus_Jakarta_Sans',Helvetica] tracking-[0]">
                      {category.name}
                    </h3>
                  </CardContent>
                </Card>
              ))}
            </div>
          </div>
        </div>

        {/* Bottom navigation */}
        <footer className="flex flex-col items-start relative self-stretch w-full flex-[0_0_auto]">
          <div className="flex items-start gap-2 pt-2 pb-3 px-4 relative self-stretch w-full flex-[0_0_auto] bg-[#f9f9f9] border-t [border-top-style:solid] border-[#ededed]">
            <div className="flex-col items-center justify-end gap-1 flex-1 grow rounded-2xl flex relative">
              <button className="inline-flex h-8 items-center justify-center relative">
                <HomeIcon className="h-6 w-6 text-[#141414]" />
              </button>
            </div>

            <div className="justify-end gap-1 flex flex-col items-center relative flex-1 grow">
              <button className="inline-flex h-8 items-center justify-center relative">
                <SearchIcon className="h-6 w-6 text-[#727272]" />
              </button>
            </div>

            <div className="justify-end gap-1 flex flex-col items-center relative flex-1 grow">
              <button className="inline-flex h-8 items-center justify-center relative">
                <HeartIcon className="h-6 w-6 text-[#727272]" />
              </button>
            </div>

            <div className="justify-end gap-1 flex flex-col items-center relative flex-1 grow">
              <button className="inline-flex h-8 items-center justify-center relative">
                <UserIcon className="h-6 w-6 text-[#727272]" />
              </button>
            </div>
          </div>

          <div className="relative self-stretch w-full h-5 bg-[#f9f9f9]" />
        </footer>
      </div>
    </div>
  );
};
