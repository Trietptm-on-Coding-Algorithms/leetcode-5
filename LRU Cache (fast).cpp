 typedef pair<int,int> KV;
 typedef list<KV>::iterator Iter;

 class LRUCache{
   public:
    LRUCache(int capacity):max_size(capacity) {

    }

    int get(int key) {
        unordered_map<int,Iter>::iterator pos = mp.find(key);
        if(pos == mp.end())
            return -1;
        else{
            Iter iter = mp[key];
            int re = iter->second;
            cache.splice(cache.begin(),cache,iter);
            return re;
        }
    }

    void set(int key, int value) {
        unordered_map<int,Iter>::iterator pos = mp.find(key);
        if(pos != mp.end()){
            mp[key]->second = value;
            Iter iter = mp[key];
            cache.splice(cache.begin(),cache,iter); 
            return; 
        }
        int cache_size = mp.size();
        if(cache_size > 0 && cache_size == max_size ){
            KV kv = *cache.rbegin();
            mp.erase(kv.first);
            cache.pop_back();         
        }
        if(mp.size() < max_size){
            cache.push_front(KV(key,value)); 
            mp[key] = cache.begin();
        }

    }

private:
    int max_size;     
    list<KV> cache;
    unordered_map<int,Iter> mp;
};