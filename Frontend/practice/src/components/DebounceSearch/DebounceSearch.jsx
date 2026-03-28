import { useState, useEffect } from "react";

export default function DebounceSearch() {
  const [query, setQuery] = useState("");
  const [debouncedQuery, setDebouncedQuery] = useState("");
  useEffect(() => {
    const timer = setTimeout(() => {
      setDebouncedQuery(query);
    }, 500);
    return () => {
      clearTimeout(timer);
    };
  }, [query]);

  useEffect(() => {
    if (debouncedQuery) {
      console.log("API call",debouncedQuery);
    }
  }, [debouncedQuery]);
  return (
    <>
      <div>DebounceSearch</div>
      <input value={query} onChange={(e) => setQuery(e.target.value)} />
    </>
  );
}
