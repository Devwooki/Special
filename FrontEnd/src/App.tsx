import { Route, Routes } from "react-router-dom";

import Home from "@components/Home";
import TestPage from "@components/TestPage";
import Navi from "@components/common/Navi";
import NotFound from "@components/common/NotFound";
import Articles from "@components/Articles";
import Article from "@components/Article";
function App() {
  console.log("시작");
  console.log(
    "한번 실행했는데 로그가 두번 찍히는 이유는 App의 rescticMode가 있기 때문에 installHook이 발생"
  );
  console.log(
    "이는 마운트를 두번 실행해도 문제가 없어야 정상적인 로직이기 때문에 안정성 검사를 하는 것과 같다."
  );
  console.log("지워도 상관은 없는데 일단 냅둠");

  return (
    <>
      <Routes>
        <Route element={<Navi />}>
          <Route path="/" element={<Home />} />
          <Route path="/test" element={<TestPage />} />
        </Route>
        <Route path="/articles" element={<Articles />}>
          <Route path=":id" element={<Article />} />
        </Route>
        <Route path="*" element={<NotFound />} />
      </Routes>
    </>
  );
}

export default App;
