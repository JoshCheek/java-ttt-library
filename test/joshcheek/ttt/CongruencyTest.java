package joshcheek.ttt;

/**
 * Created by IntelliJ IDEA.
 * User: joshuajcheek
 * Date: 8/25/11
 * Time: 12:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class CongruencyTest extends junit.framework.TestCase {

    private void assertCongruent(String board1, String board2) {
        assertTrue(Congruency.areCongruent(board1, board2));
    }

    public void testItKnows100000000_001000000_000000100_000000001AreAllCongruent() {
        assertCongruent("100000000", "001000000");
        assertCongruent("100000000", "000000100");
        assertCongruent("100000000", "000000001");
    }

    public void testItKnows120000000_100200000AreAllCongruent() {
        assertCongruent("120000000", "100200000");
    }

    public void testItKnows100020000_001020000_000020100_000020001AreAllCongruent() {
        assertCongruent("100020000", "001020000");
        assertCongruent("100020000", "000020100");
        assertCongruent("100020000", "000020001");
    }

    public void testItKnows120000001_100200001AreAllCongruent() {
        assertCongruent("120000001", "100200001");
    }

    public void testItKnows100020100_000020101_001020001_101020000AreAllCongruent() {
        assertCongruent("100020100", "000020101");
        assertCongruent("100020100", "001020001");
        assertCongruent("100020100", "101020000");
    }


//    module TTT
//      describe Congruency do
//        describe '.congruent?' do
//          [ %w[100000000 001000000 000000100 000000001],
//            %w[120000000 100200000],
//            %w[100020000 001020000 000020100 000020001],
//            %w[120000001 100200001],
//            %w[100020100 000020101 001020001 101020000],
//          ].each do |boards|
//            specify "knows #{boards.inspect} are all congruent" do
//              boards.each do |board1|
//                boards.each { |board2| Congruency.should be_congruent(board1, board2) }
//              end
//            end
//          end
//
//          [ %w[100000000 010000000 000010000 120000000],
//            %w[120000000 102000000 100020000 100000002],
//            %w[110020000 101020000 100020001],
//          ].each do |boards|
//            specify "knows #{boards.inspect} are not congruent" do
//              boards.each do |board1|
//                boards.each do |board2|
//                  next if board1 == board2
//                  Congruency.should_not be_congruent(board1, board2)
//                end
//              end
//            end
//          end
//        end
//
//        describe '.reflect_board' do
//          specify 'abcdefghi should reflect to ghidefabc' do
//            Congruency.reflect_board('abcdefghi').should == 'ghidefabc'
//          end
//          specify 'it should not mutate the original board' do
//            board = 'abcdefghi'
//            Congruency.reflect_board board
//            board.should == 'abcdefghi'
//          end
//        end
//
//        describe '.rotate_board' do
//          specify 'abcdefghi should rotate to gdahebifc' do
//            Congruency.rotate_board('abcdefghi').should == 'gdahebifc'
//          end
//          specify 'it should not mutate the original board' do
//            board = 'abcdefghi'
//            Congruency.rotate_board board
//            board.should == 'abcdefghi'
//          end
//        end
//
//        describe '.each_rotation' do
//          let(:rotations) { %w[abcdefghi gdahebifc ihgfedcba cfibehadg] }
//          subject { Congruency.each_rotation rotations.first }
//          context 'when not passed a block' do
//            it { should be_an_instance_of enumerator }
//            its(:to_a) { should == rotations }
//          end
//          context 'when passed a block' do
//            it 'yields each rotation' do
//              boards = []
//              Congruency.each_rotation rotations.first do |rotation|
//                boards << rotation
//              end
//              boards.should == rotations
//            end
//          end
//          it "isn't impacted by mutations" do
//            Congruency.each_rotation(rotations.first).with_index do |rotation, index|
//              rotation.should == rotations[index]
//              rotation[2..5] = 'xxxx'
//              rotations.first.should == 'abcdefghi'
//            end
//          end
//        end
//
//        describe '.each_congruent' do
//          let(:congruents) { %w[abcdefghi gdahebifc ihgfedcba cfibehadg ghidefabc adgbehcfi cbafedihg ifchebgda ] }
//          context 'when not passed a block' do
//            subject { Congruency.each_congruent congruents.first }
//            it { should be_an_instance_of enumerator }
//            its(:to_a) { should == congruents }
//          end
//          context 'when passed a block' do
//            it 'should yield each congruent board' do
//              boards = []
//              Congruency.each_congruent congruents.first do |congruent|
//                boards << congruent
//              end
//              boards.should == congruents
//            end
//          end
//          it "isn't impacted by mutations" do
//            Congruency.each_congruent(congruents.first).with_index do |congruent, index|
//              congruent.should == congruents[index]
//              congruent[2..5] = 'xxxx'
//              congruents.first.should == "abcdefghi"
//            end
//          end
//        end
//
//      end
//    end

}
