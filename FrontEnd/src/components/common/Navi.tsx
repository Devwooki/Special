// src/Layout.tsx
import { Outlet } from "react-router-dom";

export default function Navi() {
  return (
    <div>
      <div>헤더야 임마 페이지를 바꿔도 깜박거리지 않지</div>
      <div className="hover:bg-violet-600">테일윈드 테스트를 보려면 마우스 올려봐</div>

      <main>
        <Outlet />
      </main>
    </div>
  );
}
