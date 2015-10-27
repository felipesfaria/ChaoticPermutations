import java.util.ArrayList;

/**
 * Created by felipesfaria on 27/10/15.
 */
public class BackTracker {
        private int _n;
        private ArrayList<Integer> _state;
        private ArrayList<Integer> _possibleSteps;
        private ArrayList<ArrayList<Integer>> _finalStates;

        public BackTracker(int n){
                this._n =n;
                Init();
        }

        public ArrayList<ArrayList<Integer>> Run(){
                BackTrack();
                return _finalStates;
        }

        private void Init() {
                _state = new ArrayList<Integer>();
                _finalStates = new ArrayList<ArrayList<Integer>>();
                _possibleSteps = new ArrayList<Integer>();
                for (Integer i =0;i< _n;i++)
                        _possibleSteps.add(i);
        }

        private void BackTrack(){
                if(!LastPositionIsValid())return;
                if(IsFinalState()){
                        _finalStates.add((ArrayList<Integer>) _state.clone());
                        return;
                }
                for (int i=0;i< _possibleSteps.size();i++){
                        Integer current = _possibleSteps.get(i);
                        _possibleSteps.remove(i);
                        _state.add(current);
                        BackTrack();
                        _state.remove(current);
                        _possibleSteps.add(i,current);
                }
        }

        private boolean IsFinalState() {
                return _state.size()== _n;
        }

        private boolean LastPositionIsValid() {
                return _state.size()==0|| _state.get(_state.size()-1)!= _state.size()-1;
        }
}
